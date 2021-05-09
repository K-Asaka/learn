import pandas as pd
df = pd.read_csv('datafile/Boston.csv')     # CSVの読み込み
print(df.head(2))

df2 = df.fillna(df.mean())  # 列ごとの平均値で欠損値の穴埋め

dummy = pd.get_dummies(df2['CRIME'], drop_first = True)
df3 = df2.join(dummy)   # df2とdummyを列方向に結合
df3 = df3.drop(['CRIME'], axis = 1)     # 元のCRIMEを削除

print(df3.head(2))

from sklearn.preprocessing import StandardScaler

# 中身が整数だと、fit_transformで警告になるのでfloat型に変換(省略可能)
df4 = df3.astype('float')
# 標準化
sc = StandardScaler()
sc_df = sc.fit_transform(df4)
