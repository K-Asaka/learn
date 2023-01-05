{-# LANGUAGE OverloadedStrings #-}
module Main where

import Data.Hjq.Parser
import Test.HUnit

import Control.Lens
import Data.Monoid
import Data.Text
import qualified Data.Vector as V
import qualified Data.HashMap.Strict as H


main :: IO ()
main = do
    runTestTT $ TestList
        [ jqFilterParserTest
        -- テストケースが増えたらここに追加していく
        ]
    return ()

-- これから実装するparseJqFilterの動作を決めるため、はじめにテストを書く
jqFilterParserTest :: Test
jqFilterParserTest = TestList
    [ "jqFilterParser test 1" ~:
        parseJqFilter "." ~?= Right JqNil -- .が来たらJqNil
    , "jqFilterParser test 2" ~:
        parseJqFilter ".[0]" ~?= Right (JqIndex 0 JqNil)   -- .[0]が来たらJpIndex 0 JpNil
    , "jqFilterParser test 3" ~:
        parseJqFilter ".fieldName" ~?= Right (JqField "fieldName" JqNil)
    , "jqFilterParser test 4" ~:
        parseJqFilter ".[0].fieldName" ~?= Right (JqIndex 0 (JqField "fieldName" JqNil))
    , "jqFilterParser test 5" ~:
        parseJqFilter ".fieldName[0]" ~?= Right (JqField "fieldName" (JqIndex 0 JqNil))
    ]
