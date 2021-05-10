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
