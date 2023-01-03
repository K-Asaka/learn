module Lock
( Lock -- 値コンストラクタは外部に提供しない
, newLock
, withLock
) where

import Control.Concurrent
import Control.Exception

data Lock a = Lock (MVar a)

newLock :: a -> IO (Lock a)
newLock v = do
    mv <- newMVar v
    return $ Lock mv

withLock :: Lock a -> (a -> IO a) -> IO ()
withLock (Lock mv) act = do
    val <- takeMVar mv
    nextVal <- act val
    putMVar mv nextVal
