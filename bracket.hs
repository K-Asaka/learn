import System.IO
import Control.Exception

main :: IO ()
main = 
    bracket (openFile "dummyFileName" ReadMode) hClose $ \h -> do
        s <- hGetContents h
        putStrLn s
