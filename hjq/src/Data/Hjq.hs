module Data.Hjq where
import Data.Text as T
import Data.Hjq.Parser

-- とりあえずパターンマッチで処理
parseJqFilter :: Text -> Either String JqFilter
parseJqFilter _ = Right JqNil
