-- サンプルとしてのコード
import Control.Exception

someOperation :: IO ()
someOperation = ..略..

main :: IO ()
main = 
    someOperation
        `catch`
    (\(e :: ArithException) ->
        putStrLn $ "Catch ArithException: " ++ displayException e)
    (\(e :: SomeException) ->
        putStrLn $ "Catch SomeException: " ++ displayException e)
