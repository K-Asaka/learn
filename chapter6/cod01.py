import pandas as pd

df = pd.read_csv('datafile/cinema.csv')
print(df.head(3))

print(df.isnull().any(axis = 0))
# 欠損値を平均で補完して、df2に代入
df2 = df.fillna(df.mean())
# 穴埋めできたか確認
print(df2.isnull().any(axis = 0))
