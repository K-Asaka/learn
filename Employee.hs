data Employee = Employee
    { name :: String
    , age :: Int
    , role :: Role
    }
data Role = Engineers | Sales | Designers

data Tree a = Leaf a | Node a (Tree a) (Tree a)
