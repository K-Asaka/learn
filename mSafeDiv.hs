safeDiv :: Integer -> Integer -> Either String Integer
safeDiv k n | n == 0    = Left $ "Illegal division by zero. k:" ++ show k
            | otherwise = Right (k `div` n)

calc :: Integer -> Either String Integer
calc n = do
    x <- 100 `safeDiv` n        -- 100を引数で割る
    y <- 100 `safeDiv` (x - 1)  -- 100をx - 1で割る
    return y
