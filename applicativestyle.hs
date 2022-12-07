{-# LANGUAGE OverloadedStrings #-}
module Main(main) where

import Data.Attoparsec.Text hiding (take)

data YMD = YMD Int Int Int deriving Show

countRead :: Read a => Int -> Parser Char -> Parser a
countRead i = fmap read . count i

-- digitは0から9までの数値を表す
ymdParser :: Parser YMD
ymdParser = YMD <$> countRead 4 digit <*> countRead 2 digit <*> countRead 2 digit

main :: IO ()
main = do
    print $ parse ymdParser "20221128" `feed` ""
