# 練習5-1
import pandas as pd

# 練習5-2
df = pd.read_csv('datafile/ex2.csv')
print(df.head(3))

# 練習5-3
print(df.shape)

# 練習5-4
print(df['target'].value_counts())

# 練習5-5
print(df.isnull().sum())

# 練習5-6
df2 = df.fillna(df.median())

# 練習5-7
xcol = ['x0', 'x1', 'x2', 'x3']
x = df2[xcol]
t = df2['target']

# 練習5-9
from sklearn.model_selection import train_test_split

x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)

#練習5-11
from sklearn import tree

model = tree.DecisionTreeClassifier(max_depth = 3, random_state = 0)
model.fit(x_train, y_train)

# 練習5-13
print(model.score(x_test, y_test))

# 練習5-14
newdata = [[1.56, 0.23, -1.1, -2.8]]

answer = model.predict(newdata)
print(answer)
