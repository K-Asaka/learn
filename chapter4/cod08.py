import pandas as pd

# KvsT.csvファイルを読み込んで、データフレームに変換
df = pd.read_csv('datafile/KvsT.csv')
# 先頭3行だけ表示
print(df.head(3))

# 指定した列だけを参照する
print(df['身長'])

# 複数の列を一度に参照する
# 抜き出したい列名の文字列リストを作成
col = ['身長', '体重']
# 身長列と体重列のみを抜き出す
print(df[col])

# 1列だけ抜き出したデータの型
print(type(df['派閥']))

# 1次元のデータを扱うSeries型
print(df['派閥'])
