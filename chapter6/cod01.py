import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('datafile/cinema.csv')
print(df.head(3))

print(df.isnull().any(axis = 0))
# 欠損値を平均で補完して、df2に代入
df2 = df.fillna(df.mean())
# 穴埋めできたか確認
print(df2.isnull().any(axis = 0))

# SNS2とsalesの散布図の作成
# for name in df.columns:     # for name in df: でも可
#     # X軸がcinema_id列とsales列の散布図は作っても意味がないので外す
#     if name == 'cinema_id' or name == 'sales':
#         continue

#     df2.plot(kind = 'scatter', x = name, y = 'sales')
# plt.show()

no = df2[(df2['SNS2'] > 1000) & (df2['sales'] < 8500)].index
df3 = df2.drop(no, axis = 0)

# 特徴量の列の候補
#col = ['SNS1', 'SNS2', 'actor', 'original']
#x = df3[col]        # 特徴量の取り出し
#t = df3['sales']    # 正解データの取り出し

# インデックスが2、列がSNS1のマスの値のみ参照
print(df3.loc[2, 'SNS1'])

# 特定のデータのみを参照
index = [2, 4, 6]           # インデックス
col = ['SNS1', 'actor']     # 列名
print(df3.loc[index, col])

# スライス構文で連続した要素を参照する
sample = [10, 20, 30, 40]   # リストの作成
print(sample[1:3])          # 添え字が1以上3未満の要素を取得

# 0行目以上2行目以下、actor列より左の列(actor列含む)
print(df3.loc[0:3, :'actor'])

# スライス構文で特徴量と正解データを取り出す
x = df3.loc[ : , 'SNS1':'original'] # 特徴量の取り出し
t = df3['sales']                    # 正解ラベルの取り出し

# 訓練データとテストデータに分割する
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)

# 重回帰モデルの作成と学習
from sklearn.linear_model import LinearRegression

model = LinearRegression()
print(model.fit(x_train, y_train))
