module Main where

import Control.Exception (bracket, finally)
import Control.Monad (forM_)
import System.IO
    ( stdout, Handle, FilePath, IOMode(..)
    , openFile, hClose, hIsEOF, hGetLine, hPutStrLn
    )
import System.Environment (getArgs)
import Data.Char (toUpper)

-- 標準出力に書き出す
main :: IO ()
main = do
    filePaths <- getArgs
    concatMultiFiles filePaths stdout

-- 複数ファイルをそれぞれ引数の出力先に出力
concatMultiFiles :: [FilePath] -> Handle -> IO ()
concatMultiFiles filePaths dst =
    forM_ filePaths $ \filePath ->
        bracket
            (openFile filePath ReadMode)
            (\hdl -> hClose hdl)
            (\hdl -> copyFile hdl dst)

-- 1つのフィルを引数の出力先に出力
copyFile :: Handle -> Handle -> IO ()
copyFile src dst = loop
    where
        loop = do
            isEof <- hIsEOF src
            if isEof
                then return ()
                else do
                    line <- hGetLine src
                    hPutStrLn dst (map toUpper line)    -- 変更した
                    loop
