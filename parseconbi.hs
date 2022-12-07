{-# LANGUAGE OverloadedStrings #-}
module Main(main) where

import Control.Applicative ((<|>))
import Data.Attoparsec.Text

twoOfDecimal :: Parser (Int, Int)
twoOfDecimal = do
    left <- decimal
    char ','
    right <- decimal
    return (left, right)

parens :: Parser a -> Parser a
parens parser = do
    char '('
    res <- parser
    char ')'
    return res

data Animal = Dog | Pig deriving Show

animal :: Parser Animal
animal = (string "Dog" >> return Dog) <|> (string "Pig" >> return Pig)

main :: IO ()
main = do
    print $ parse animal "Dog" `feed` ""
    print $ parse animal "Pig" `feed` ""
    print $ parse animal "Cat" `feed` ""
