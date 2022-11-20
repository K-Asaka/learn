-- State sモナドを使う場合transformersパッケージが必要
-- $ stack ghci --package transformers
import Control.Monad.Trans.State
import Data.List

type Card = Int         -- カード
type Score = Int        -- 得点
type Hand = [Card]      -- 手札
type Stock = [Card]     -- 山札
type Player = String    -- プレイヤー

-- 山札から指定した枚数のカードを引く
drawCards :: Int
  -> State Stock Hand   -- 状態は山札、返り値は手札
drawCards n = do
  -- 状態である山札を取得する
  deck <- get
  -- 引いた残りを新たに山札に設定
  put $ drop n deck
  -- 引いたカードを返す
  return $ take n deck

-- ランダムな並び順のカード一式 deck :: [Card] があるとする
-- 太郎、花子、たかし、ゆみの四人に5枚づつカードを配り、合計点が多い人が勝ち
-- 返却値は合計点の多い順でソートされた(合計得点, 手札, プレイヤー名)のリスト
gameWithState
  -- 状態は山札、返り値は(得点、手札、プレイヤー名)のリスト
  :: State Stock [(Score, Hand, Player)]
gameWithState = do
  -- 四人分のカードを配る
  taroHand <- drawCards 5
  hanakoHand <- drawCards 5
  takashiHand <- drawCards 5
  yumiHand <- drawCards 5
  -- 逆順にソートすれば合計得点が高い順に並ぶ、sortにはData.Listが必要
  return . reverse . sort $
    [ (sum taroHand, taroHand, "Taro")
    , (sum hanakoHand, hanakoHand, "Hanako")
    , (sum takashiHand, takashiHand, "Takashi")
    , (sum yumiHand, yumiHand, "Yumi")
    ]
  -- さらにデッキにカードを戻す処理も実装する必要がある...

main :: IO ()
main = 
  print $ runState gameWithState [1..50]
