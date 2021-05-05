import pandas as pd

df = pd.read_csv('datafile/iris.csv')
print(df.head(3))

# array型の特定要素を参照
syurui = df['種類'].unique()
print(syurui[0])

# value_countsメソッドでデータの出現回数をカウント
print(df['種類'].value_counts())

# tailメソッドでデータフレームの末尾3行を表示
print(df.tail(3))

# isnullメソッドで欠損値の有無を調べる
print(df.isnull())

# 列単位で欠損値が存在するか調べる
print(df.isnull().any(axis = 0))

# sumメソッドで各列の合計値を求める
print(df.sum())

# 各列に欠損値がいくつあるか集計
tmp = df.isnull()
print(tmp.sum())

# 欠損値が1つでもある行を削除した結果を、df2に代入
df2 = df.dropna(how = 'any', axis = 0)
print(df2.tail(3))

# 削除元のデータフレームを確認
print(df.isnull().any(axis = 0))

# fillnaメソッドで欠損値を指定した値に書き換える
df['花弁長さ'] = df['花弁長さ'].fillna(0)
print(df.tail(3))

# 数値列の各平均値を計算(文字列の列は自動的に除外してくれる)
print(df.mean())

# 「がく片長さ」列の平均値を計算
print(df['がく片長さ'].mean())

# 標準偏差の計算
print(df.std())


# 欠損値を0で置き換えてしまったのでもう一度読み込み直し
df = pd.read_csv('datafile/iris.csv')

# 各列の平均値を計算して、colmeanに代入
colmean = df.mean()

# 平均値で欠損値を穴埋めしてdf2に代入
df2 = df.fillna(colmean)

# 欠損値があるか確認
print(df2.isnull().any(axis = 0))

# 特徴量と正解データを変数に代入
xcol = ['がく片長さ', 'がく片幅', '花弁長さ', '花弁幅']

x = df2[xcol]
t = df2['種類']
