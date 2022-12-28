{-# LANGUAGE TemplateHaskell, OverloadedStrings, OverloadedLists #-}

import Data.Aeson -- aeson
import Data.Aeson.TH -- aeson
import qualified Data.ByteString.Lazy.Char8 as B -- bytestring

-- JSONにしたいデータ
data Human = Human
    { name :: String
    , age :: Int
    } deriving Show

data Department = Department
    { departmentName :: String
    , coworkers :: [Human]
    } deriving Show

deriveJSON defaultOptions ''Human   -- ''Humanという記法がTemplate Haskell由来
deriveJSON defaultOptions ''Department

taro :: Human
taro = Human { name = "Taro", age = 30 }

saburo :: Human
saburo = Human { name = "Saburo", age = 31 }

shiro :: Human
shiro = Human { name = "Shiro", age = 31 }

matsuko :: Human
matsuko = Human { name = "Matsuko", age = 26 }

nameList :: [Department]
nameList =
    [ Department
        { departmentName = "General Affairs"
        , coworkers =
            [ taro
            , matsuko
            ]
        }
      , Department
        { departmentName = "Development"
        , coworkers =
            [ saburo
            , shiro
            ]
        }
    ]

data IntStr = IntData Int | StrData String
deriveJSON defaultOptions ''IntStr

main :: IO ()
main = do
    B.putStrLn $ encode $ nameList

    B.putStrLn $ encode $ IntData 999
    B.putStrLn $ encode $ StrData "World!"
