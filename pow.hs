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
