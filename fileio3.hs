main :: IO ()
main = do
    val <- readFile "sample1.txt"
    putStrLn $ take 5 val
    writeFile "sample.txt" "Hello, Lazy IO!"
