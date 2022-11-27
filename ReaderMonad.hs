{-# LANGUAGE FlexibleContexts, GeneralizedNewtypeDeriving #-}
import Control.Monad.Reader     -- stack ghci --package mtl

newtype Name = Name String
newtype Path = Path String
data DefaultValues = DefaultValues
    { defaultName :: Name
    , defaultPath :: Path
    }

getDefaultName :: MonadReader DefaultValues m => m Name -- MonadReaderの型制約
getDefaultName = asks defaultName

getDefaultPath :: MonadReader DefaultValues m => m Path
getDefaultPath = asks defaultPath

newtype MyApp a = MyApp { unMyApp :: ReaderT DefaultValues IO a }
    deriving (Functor, Applicative, Monad, MonadReader DefaultValues)

runMyApp :: DefaultValues -> MyApp a -> IO a
runMyApp def app = runReaderT (unMyApp app) def
