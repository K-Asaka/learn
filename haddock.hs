-- |Module         : Main
-- |
-- |MainモジュールのHaddock用ドキュメント
module Main (main) where

main :: IO ()
-- ^main関数のHaddock用ドキュメントです
main = do
    -- これはコメント行です
    putStr "Hello, "
    {-
        これもコメントです。
        複数行書けます。
    -}
    putStrLn "World!"
