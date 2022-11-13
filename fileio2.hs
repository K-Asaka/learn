main :: IO ()
-- main = readFile "sample1.hs" >>= putStrLn   -- 遅延I/Oが有効
main = readFile "sample1.hs" >>= putStrLn . reverse -- 遅延I/Oに意味がない
