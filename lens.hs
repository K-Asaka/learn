
{-# LANGUAGE TemplateHaskell #-}
import Control.Lens

main :: IO ()
main = do
    let leftVal = Left "Left Value" :: Either String String
    print $ leftVal&_Left.~"New Value"
    print $ leftVal&_Right.~"New Value"
    print $ leftVal^?_Left
    print $ leftVal^?_Right
