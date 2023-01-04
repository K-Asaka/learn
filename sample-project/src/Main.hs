module Main where

import Control.Monad (forever)
import Control.Concurrent (threadDelay)
import Control.Concurrent.Async (race_)

main :: IO ()
main = do
    putStrLn "Using race_"
    race_ thread1 thread2
  where
    thread1 = do
        threadDelay 2000000 -- 2sec
        putStrLn "Thread1: end"
    thread2 = forever $ do
        putStrLn "Thread2: Can you her me?"
        threadDelay 500000 -- 0.5sec
