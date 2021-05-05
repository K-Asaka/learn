import pandas as pd

df = pd.read_csv('datafile/KvsT.csv')

# 特徴量の列を参照してxに代入
xcol = ['身長', '体重', '年代']
x = df[xcol]
print(x)

# 正解データ(派閥)を参照して、tに代入
t = df['派閥']
print(t)
