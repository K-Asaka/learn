{-# LANGUAGE TemplateHaskell, OverloadedStrings, OverloadedLists #-}

import Data.Aeson -- aeson
import Data.Aeson.TH -- aeson
import qualified Data.ByteString.Lazy.Char8 as B -- bytestring

-- JSONにしたいデータ
data Human = Human
    { name :: String
    , age :: Int
    } deriving Show

deriveJSON defaultOptions ''Human   -- ''Humanという記法がTemplate Haskell由来

taro :: Human
taro = Human
    { name = "Taro"
    , age = 30
    }

hanako :: B.ByteString
hanako = "{\"name\":\"Hanako\",\"age\":25}"

jiro :: B.ByteString
jiro = "{\"onamae\":\"Jiro\",\"nenrei\":30}"

main :: IO ()
main = do
    print (eitherDecode hanako :: Either String Human)
    print (eitherDecode jiro :: Either String Human)
