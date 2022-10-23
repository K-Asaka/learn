import Data.List (intercalate)

data Dog = Dog deriving Show
data Cat = Cat deriving Show
data Human = Human String deriving Show

class Greeting a where
    name  :: a -> String
    hello :: a -> String
    hello _ = "..." -- hello関数のデフォルトの実装
    bye   :: a -> String
    bye   _ = "..." -- bye関数のデフォルトの実装

instance Greeting Human where
    name  (Human n) = n
    hello h         = "Hi, I'm " ++ name h ++ "."
    bye   _         = "See you."

instance Greeting Dog where
    name  _ = "a dog"
    hello _ = "Bark!"

instance Greeting Cat where
    name  _ = "a cat"
    bye   _ = "Meow..."


sayHello :: Greeting a => a  -> IO ()
sayHello x = putStrLn (hello x)

class Greeting a => Laughing a where
    laugh :: a -> String

instance Laughing Human where
    laugh _ = "Zehahahah...!!"

leaveWithLaugh :: Laughing a => a -> IO ()
leaveWithLaugh x = do
    putStrLn (bye x)
    putStrLn (laugh x)


-- `f`で得られる文字列を改行で連結する関数の定義
-- intercalateは第一引数に連結に使う文字列、第二引数に連結したい文字列のリストをとる
liftGreet :: (a -> String) -> ([a] -> String)
liftGreet f = intercalate "\n" . map f

instance Greeting a => Greeting [a] where
    name  = liftGreet name
    hello = liftGreet hello
    bye   = liftGreet bye

