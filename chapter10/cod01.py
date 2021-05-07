import pandas as pd

df = pd.read_csv('datafile/bike.tsv', sep = '\t')
print(df.head(3))

df2 = pd.read_csv('datafile/weather.csv')
print(df2.head(3))

weather = pd.read_csv('datafile/weather.csv', encoding = 'shift-jis')

temp = pd.read_json('datafile/temp.json')
print(temp.head(2))
print(temp.T)

df2 = df.merge(weather, how = 'inner', on = 'weather_id')
print(df2.head(2))

print(df2.groupby('weather').mean()['cnt'])

temp = temp.T
print(temp.loc[199:201])

print(df2[df2['dteday'] == '2011-07-20'])

df3 = df2.merge(temp, how = 'left', on = 'dteday')
print(df3[df3['dteday'] == '2011-07-20'])

import matplotlib.pyplot as plt
# df3['temp'].plot(kind = 'line')
# plt.show()

# df3[['temp', 'hum']].plot(kind = 'line')
# plt.show()

# df3['temp'].plot(kind = 'hist')
# df3['hum'].plot(kind = 'hist', alpha = 0.5)
# plt.show()

# インデックス220～240を抜き出して、折れ線グラフで表示
# df3['atemp'].loc[220:240].plot(kind = 'line')
# plt.show()

# atemp列の型をfloatに変換
df3['atemp'] = df3['atemp'].astype(float)
df3['atemp'] = df3['atemp'].interpolate()    # 欠損値を線形補間
# df3.loc[225:235, 'atemp'].plot(kind = 'line')
# plt.show()

# 「がく片弁長さ」列に2個の欠損がある
iris_df = pd.read_csv('datafile/iris.csv')
non_df = iris_df.dropna()   # 欠損値を含む行を削除
from sklearn.linear_model import LinearRegression
x = non_df.loc[ : , 'がく片幅':'花弁幅']
t = non_df['がく片長さ']
model = LinearRegression()
model.fit(x, t)     # 欠損値予測のためのモデルを予測

# 欠損行の抜き出し
condition = iris_df['がく片長さ'].isnull()
non_data = iris_df.loc[condition]

# 欠損行の入力に利用する特徴量だけを抜き出して、モデルで予測
x = non_data.loc[ : , 'がく片幅':'花弁幅']
pred = model.predict(x)

# 欠損行のがく片長さのマスを抜き出して、predで代入
iris_df.loc[condition, 'がく片長さ'] = pred
print(iris_df.loc[condition, 'がく片長さ'])

# DBの準備はしていないため、このコードはエラーになる
dbname = 'Test.db'
import sqlite3
conn = sqlite3.connect(dbname)
# test表のid列の値が2の行だけを抽出
sql = 'SELECT * FROM test WHERE id = 2'
df = pd.read_sql(sql, con = conn)
