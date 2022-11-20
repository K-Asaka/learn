import Data.List

type Card = Int         -- カード
type Score = Int        -- 得点
type Hand = [Card]      -- 手札
type Stock = [Card]     -- 山札
type Player = String    -- プレイヤー

deck :: [Card]
deck = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
       , 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
       , 21, 22, 23, 24, 25, 26, 27, 28, 29, 30
       ]

-- ランダムな並び順のカード一式 deck :: [Card] があるとする
-- 太郎、花子、たかし、ゆみの四人に5枚づつカードを配り、合計点が多い人が勝ち
-- 返却値は合計点の多い順でソートされた(合計得点, 手札, プレイヤー名)のリスト
game :: [Card] -> [(Score, Hand, Player)]
game deck = let
    (taroHand, deck2) = (take 5 deck, drop 5 deck)
    (hanakoHand, deck3) = (take 5 deck2, drop 5 deck2)
    (takashiHand, deck4) = (take 5 deck3, drop 5 deck3)
    (yumiHand, deck5) = (take 5 deck4, drop 5 deck4)
  -- 逆順にソートすれば合計得点が高い順に並ぶ、sortにはData.Listが必要
  in reverse . sort $
    [ (sum taroHand, taroHand, "Taro")
    , (sum hanakoHand, hanakoHand, "Hanako")
    , (sum takashiHand, takashiHand, "Takashi")
    , (sum yumiHand, yumiHand, "Yumi")
    ]
  -- さらにデッキにカードを戻す処理も実装する必要がある...


main :: IO ()
main = do
    print $ game deck
