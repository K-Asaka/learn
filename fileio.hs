main :: IO ()
main = do
    writeFile "sample.txt" "Hello"
    -- readFile "sample.txt"
    appendFile "sample.txt" ", World!"
    -- readFile "sample.txt"
