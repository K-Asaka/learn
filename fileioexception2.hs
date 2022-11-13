{-# LANGUAGE ScopedTypeVariables #-}    -- GHCの言語拡張を有効にする
import Control.Exception

main :: IO ()
main =
    (readFile "dummyFileName" >>= putStrLn)
        `catch`
    (\(e :: SomeException) ->
        putStrLn $ "readFile failure!!! : " ++ displayException e)
