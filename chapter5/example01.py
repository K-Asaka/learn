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
