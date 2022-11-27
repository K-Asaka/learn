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
    handleMultiFiles filePaths (\hdl -> copyFile hdl dst)

handleMultiFiles :: [FilePath] -> (Handle -> IO ()) -> IO ()
handleMultiFiles filePaths fileHandler =
    forM_ filePaths $ \filePath ->
        bracket
            (openFile filePath ReadMode)
            (\hdl -> hClose hdl)
            (\hdl -> fileHandler hdl)

-- 1つのフィルを引数の出力先に出力
copyFile :: Handle -> Handle -> IO ()
copyFile src dst = copyFileWithConvert src dst id   -- `id`を使って再実装

copyFileWithConvert :: Handle -> Handle -> (String -> String) -> IO ()
copyFileWithConvert src dst convert = loop
    where
        loop = do
            isEof <- hIsEOF src
            if isEof
                then return ()
                else do
                    line <- hGetLine src
                    hPutStrLn dst (convert line)
                    loop

-- copyFileのバリエーション
-- 第三引数の関数は、文字列を用いたI/Oアクションに変更している
foreachLineAndAppend :: Handle -> Handle -> (String -> IO String) -> IO ()
foreachLineAndAppend src dst ioAction =
    foreachLine src $ \line -> do
        output <- ioAction line
        hPutStrLn dst output

-- 抽象度を高める
foreachLine :: Handle -> (String -> IO ()) -> IO ()
foreachLine src ioAction = loop
    where
        loop = do
            isEof <- hIsEOF src
            if isEof
                then return ()
                else do
                    line <- hGetLine src
                    ioAction line
                    loop
