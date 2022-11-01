import Data.Char

main :: IO () -- Control-C
main = do
    xs <- getContents
    putStr $ map toUpper xs
