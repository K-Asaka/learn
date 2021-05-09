import pandas as pd
import matplotlib.pyplot as plt

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

from sklearn.decomposition import PCA

model = PCA(n_components = 2, whiten = True)    # モデル作成

# モデルに学習させる
model.fit(sc_df)

# 新規の第1軸(第1主成分とも呼ぶ)の固有ベクトル
print(model.components_[0])
print('-----')
# 新規の第2軸(第2主成分とも呼ぶ)の固有ベクトル
print(model.components_[1])

new = model.transform(sc_df)

new_df = pd.DataFrame(new)
print(new_df.head(3))

new_df.columns = ['PC1', 'PC2']
# 標準化済の既存データ(numpy)をデータフレーム化
df5 = pd.DataFrame(sc_df, columns = df4.columns)
# 2つのデータフレームを列方向に結合
df6 = pd.concat([df5, new_df], axis = 1)

df_corr = df6.corr()    # 相関係数の計算
print(df_corr.loc[ :'very_low', 'PC1': ])

# わかりやすいように変数に代入
pc_corr = df_corr.loc[ :'very_low', 'PC1': ]

print(pc_corr['PC1'].sort_values(ascending = False))
print(pc_corr['PC2'].sort_values(ascending = False))

# 都市の発展度合いと住環境の良さ
col = ['City', 'Exclusive residential']
new_df.columns = col    # 列名の変更
new_df.plot(kind = 'scatter', x = 'City', y = 'Exclusive residential')  # 散布図
plt.show()

model = PCA(whiten = True)
# 学習と新規軸へのデータの当てはめを一括で行う
tmp = model.fit_transform(sc_df)
print(tmp.shape)
