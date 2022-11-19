type Category = String -- 商品のカテゴリ
type Name = String -- 商品名
type Price = Integer -- 金額
type Menu = [(Category, [(Name, Price)])]   -- メニュー
type Item = (Category, Name, Price) -- 商品

-- メニューデータの例
menu :: Menu
menu = 
    [ ("Foods", -- 食事
        [ ("Hamburger", 120)    -- ハンバーガー
        , ("FrenchFries", 100)  -- ポテト
        ] )
    , ("Drinks", -- 飲み物
        [ ("Cola", 80)  -- コーラ
        , ("Tea", 100)  -- お茶
        ] )
    ]

getItemWithoutMonado :: Menu -> Category -> Name -> Maybe Item
getItemWithoutMonado menu category name
    -- パターンマッチするたびにネストが増えてしまう
    = case lookup category menu of
      Just subMenu -> case lookup name subMenu of
        Just price -> Just (category, name, price)
        -- マッチしなかった場合はNothing
        Nothing -> Nothing
      -- この計算ではマッチしなかったときの処理はNothingと決まっているので何度も書きたくない
      Nothing -> Nothing

f :: Maybe Int
f = do
    x <- Just 10
    Nothing   -- Nothingが途中で現れるとその後の計算を無視してNothingを返す
    return $ x * 2

f' :: Maybe Int
f' = Just 10 >>= \x -> Nothing >>= \_ -> return (x * 2)

main :: IO ()
main = do
    putStrLn "Hello!!"
    print f
    print f'
    print c
    print n

