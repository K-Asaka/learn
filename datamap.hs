import qualified Data.Map.Strict as M

dict' :: M.Map String Integer
dict' = M.insert "hiratara" 39
      . M.insert "shu1"      0
      . M.insert "masahiko" 63
      $ M.empty
