import pandas as pd

df = pd.read_csv('datafile/Wholesale.csv')
print(df.head(3))

print(df.isnull().sum())

df = df.drop(['Channel', 'Region'], axis = 1)

from sklearn.preprocessing import StandardScaler

sc = StandardScaler()
sc_df = sc.fit_transform(df)
sc_df = pd.DataFrame(sc_df, columns = df.columns)

from sklearn.cluster import KMeans

model = KMeans(n_clusters = 3, random_state = 0)

# モデルに学習させる
model.fit(sc_df)

print(model.labels_)

sc_df['cluster'] = model.labels_
print(sc_df.head(2))

print(sc_df.groupby('cluster').mean())

import matplotlib.pyplot as plt
cluster_mean = sc_df.groupby('cluster').mean()
cluster_mean.plot(kind = 'bar')
plt.show()

sse_list = []
# クラスタ数2～30でSSE(クラスタ内誤差平方和)を調べる
for n in range(2, 31):
    model = KMeans(n_clusters = n, random_state = 0)
    model.fit(sc_df)
    sse = model.inertia_    # SSEの計算
    sse_list.append(sse)

print(sse_list)

se = pd.Series(sse_list)
num = range(2, 31)      # range関数で2～30の整数列を作る
se.index = num          # シリーズのインデックスを変更
se.plot(kind = 'line')
plt.show()
