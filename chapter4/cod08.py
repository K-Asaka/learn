import pandas as pd

# KvsT.csvファイルを読み込んで、データフレームに変換
df = pd.read_csv('datafile/KvsT.csv')
# 先頭3行だけ表示
print(df.head(3))
