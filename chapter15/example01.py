# 練習15-1
import pandas as pd

df = pd.read_csv('datafile/Survived.csv')

# 練習15-2
df = df.drop(['PassengerId', 'Ticket', 'Cabin', 'Embarked'], axis = 1)

# 練習15-3
df = df.fillna(df.mean())

# 練習15-4
dummy = pd.get_dummies(df['Sex'], drop_first = True)
df = pd.concat([df, dummy], axis = 1)
df = df.drop('Sex', axis = 1)

# 練習15-5
from sklearn.covariance import MinCovDet
import matplotlib.pyplot as plt

mcd = MinCovDet()
mcd.fit(df)
maha_dis = mcd.mahalanobis(df)
tmp = pd.Series(maha_dis)
tmp.plot(kind = 'box')
plt.show()

num = tmp[tmp > 10000].index
df = df.drop(num)

# 練習15-6
from sklearn.preprocessing import StandardScaler

sc = StandardScaler()
sc_df = sc.fit_transform(df)
df2 = pd.DataFrame(sc_df, columns = df.columns)

# 練習15-7
from sklearn.cluster import KMeans

model = KMeans(n_clusters = 2, random_state = 0)
model.fit(df2)

df2['cluster'] = model.labels_

# 練習15-8
c = df2.groupby('cluster').mean()
c.plot(kind = 'bar')
plt.show()
