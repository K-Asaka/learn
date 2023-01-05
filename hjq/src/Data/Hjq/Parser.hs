{-# LANGUAGE OverloadedStrings #-}
module Data.Hjq.Parser where
import Control.Applicative
import Data.Attoparsec.Text
import Data.Text

-- ユーザが入力する文字列用の構文木、それぞれフィールド名、インデックス、何もしない入力
data JqFilter
    = JqField Text JqFilter
    | JqIndex Int JqFilter
    | JqNil -- フィールド名とインデックスが存在しない場合にも使う
    deriving (Show, Read, Eq)

-- ユーザの入力をパースする
parseJqFilter :: Text -> Either Text JqFilter
parseJqFilter s = showParseResult
    $ parse (jqFilterParser <* endOfInput) s `feed` ""

schar :: Char -> Parser Char
schar c = skipSpace *> char c <* skipSpace

-- attoparsecを使ってフィルタの文字列をJqFilter型にパース
jqFilterParser :: Parser JqFilter
jqFilterParser = schar '.' >> (jqField <|> jqIndex <|> pure JqNil)
  where
    jqFilter :: Parser JqFilter
    jqFilter
        = (schar '.' >> jqField) <|> jqIndex <|> pure JqNil

    jqField :: Parser JqFilter
    jqField = JqField <$> (word <* skipSpace) <*> jqFilter
        
    jqIndex :: Parser JqFilter
    jqIndex = JqIndex <$> (schar '[' *> decimal <* schar ']') <*> jqFilter
    
-- パース結果の表示
showParseResult :: Show a => Result a -> Either Text a
showParseResult (Done _ r) = Right r
showParseResult r = Left . pack $ show r

-- フィールド名などの識別子をパースするパーサ
word :: Parser Text
word = fmap pack $ many1 (letter <|> char '-' <|> char '_' <|> digit)


data JqQuery
    = JqQueryObject [(Text, JqQuery)]
    | JqQueryArray [JqQuery]
    | JqQueryFilter JqFilter
    deriving (Show, Read, Eq)

parseJqQuery :: Text -> Either Text JqQuery
parseJqQuery s = showParseResult $ parse (jqQueryParser <* endOfInput) s `feed` ""

-- パーサ本体
jqQueryParser :: Parser JqQuery
jqQueryParser = queryArray <|> queryFilter <|> queryObject
    where
        queryArray :: Parser JqQuery
        queryArray = JqQueryArray <$> (schar '[' *> jqQueryParser `sepBy` (schar ',') <* schar ']')

        queryObject :: Parser JqQuery
        queryObject = JqQueryObject <$> (schar '{' *> (qObj `sepBy` schar ',') <* schar '}')

        qObj :: Parser (Text, JqQuery)
        qObj = (,) <$> (schar '"' *> word <* schar '"') <*> (schar ':' *> jqQueryParser)


        queryFilter :: Parser JqQuery
        queryFilter = JqQueryFilter <$> jqFilterParser
