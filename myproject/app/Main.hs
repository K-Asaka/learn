import Pipes
import qualified Pipes.Prelude as P

hello :: Pipe String String IO r
hello = do
    P.mapM $ \s -> do
        putStrLn $ "input : " ++ s
        return $ "Hello, " ++ s

main :: IO ()
main = sample1


sample1 :: IO ()
sample1 = runEffect $ sampleProducer >-> P.map ("input : "++) >-> P.stdoutLn

sampleProducer :: Producer String IO ()
sampleProducer = do
    yield "Hoge"
    yield "Piyo"
    yield "Fuga"
