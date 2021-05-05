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
