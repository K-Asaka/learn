# 練習6-1
import pandas as pd

df = pd.read_csv('datafile/ex3.csv')

# 練習6-2
print(df.head(5))

# 練習6-4
print(df.isnull().sum())
df2 = df.fillna(df.median())

# 練習6-5
import matplotlib.pyplot as plt
#df2.plot(kind = 'scatter', x = 'x0', y = 'target')
#plt.show()

# 練習6-6
for name in df.columns:
    if name == 'target':
        continue
    df2.plot(kind = 'scatter', x = name, y = 'target')
plt.show()

# 練習6-7
no = df2[(df2['x2'] < -2) & (df2['target'] > 100)].index
df3 = df2.drop(no, axis = 0)

# 練習6-8
x = df3.loc[ : , :'x3']
t = df3['target']

# 練習6-9
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 1)
