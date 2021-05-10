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
