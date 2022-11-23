-- 後で使うためlocalもimportする
import Control.Monad.Trans.Reader (Reader, runReader, asks, local)
-- powEnergyが消費電力量、powSaveModeが省電力機能のON・OFF
data PowerEnv = PowerEnv { powEnergy   :: !Double 
                         , powSaveMode :: !Bool
                         }

-- 実際の電力消費量を算出
consume :: Reader PowerEnv Double
consume = do
    energy   <- asks powEnergy
    savemode <- asks powSaveMode
    let consumption = if savemode then energy / 10.0
                                  else energy
    return consumption

testrun :: PowerEnv -> Double
testrun env = (`runReader` env) $ do
    cons1 <- consume
    cons2 <- consume
    consOthers <- local (\e -> e {powSaveMode = True}) $ do
        cons3 <- consume    -- localの影響を受ける
        cons4 <- consume    -- localの影響を受ける
        return (cons3 + cons4)
    return (cons1 + cons2 + consOthers)
