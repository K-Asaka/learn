{-# LANGUAGE TemplateHaskell, OverloadedStrings, OverloadedLists #-}

import Data.Aeson -- aeson
import qualified Data.ByteString.Lazy.Char8 as B -- bytestring

nameListValue :: Value
nameListValue = Array
    [ object
        [ "coworkers" .= Array
            [ object
                [ "age" .= Number 20
                , "name" .= String "Satoshi"
                ]
            , object
                [ "age" .= Number 23
                , "name" .= String "Takeshi"
                ]
            ]
          , "departmentName" .= String "Planning"
        ]
    ]

main :: IO ()
main = do
    B.putStrLn $ encode $ nameListValue
    