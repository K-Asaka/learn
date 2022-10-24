main :: IO ()
--main = 
--    getLine >>= \x ->   -- 変数xに代入しているように見える
--    getLine >>= \y ->   -- 変数yに代入しているように見える
--    putStrLn ("1つ目の入力：" ++ x) >>
--    putStrLn ("2つ目の入力：" ++ y)

main = do
--    x <- getLine    -- getLineの返り値を束縛
--    y <- getLine    -- getLineの返り値を束縛
--    putStrLn $ "1つ目の入力：" ++ x
--    putStrLn $ "2つ目の入力：" ++ y
    x <- getLine
    putStrLn $ "1つ目の入力：" ++ x
    getLine >>= return . ("2つ目の入力：" ++) >>= putStrLn
