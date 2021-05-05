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
