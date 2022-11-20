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
category :: Category
category = "Foods"
name :: Name
name = "Hamburger"

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

getItemWithMonado :: Menu -> Category -> Name -> Maybe Item
getItemWithMonado menu category name = do
    -- IOでgetLineしたときのように、lookup関数が使える
    subMenu <- lookup category menu
    price <- lookup name subMenu
    -- どこかのアクションがNothingを返せば、計算全体がNothingとなる
    -- 最終的に欲しい結果を組み立ててreturnで返す
    return (category, name, price)

f :: Maybe Int
f = do
    x <- Just 10
    Nothing   -- Nothingが途中で現れるとその後の計算を無視してNothingを返す
    return $ x * 2

f' :: Maybe Int
f' = Just 10 >>= \x -> Nothing >>= \_ -> return (x * 2)

main :: IO ()
main = do
    --let category="aaaa"
    print $ getItemWithoutMonado menu category name
    print $ getItemWithMonado menu category name
