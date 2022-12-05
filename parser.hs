{-# LANGUAGE OverloadedStrings #-}
import qualified Data.Text as T  -- 重複を防ぐ
import Data.Attoparsec.Text hiding (take)

main :: IO ()
main = do
    print $ parse decimal "1000" `feed` ""
