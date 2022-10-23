type Age = Integer -- typeに続き左辺に新しい型名、右辺にもともとの型名を書く

legalDrink :: Age -> Bool
legalDrink age | age >= 20 = True
               | otherwise = False

data AppErr = NewAppErr deriving Show
type AppResult a = Either AppErr a

safeHead :: [a] -> AppResult a
safeHead [] = Left  NewAppErr
safeHead xs = Right (head xs)
