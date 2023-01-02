import Control.Concurrent

actionIO :: IO a => IO a
actionIO action = do
    mv <- newEmptyMVar :: IO (MVar (Either SomeException a))
    _tid <- forkIO $ do
        result <- try action
        putMVar mv result
    result <- takeMVar mv
    case result of
        Left e -> throwIO e
        Right r -> return r

main :: IO ()
main = do
    -- スレッド間で共有するMVar生成
    m <- newEmptyMVar
    
    -- スレッド生成
    forkIO $ do
        tid <- myThreadId   -- 現在のスレッドIDを取得
        putStrLn $ show tid ++ ": doing ... heavy ... task ..."
        threadDelay 2000000 -- マイクロ秒単位でスレッド実行を停止
        putMVar m ()        -- 処理が終わったことを通知

    takeMVar m              -- 生成したスレッドから通知が来るまで待ち続ける
    putStrLn "Done"
