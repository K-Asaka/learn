# 練習6-1
import pandas as pd

df = pd.read_csv('datafile/ex3.csv')

# 練習6-2
print(df.head(5))

# 練習6-4
print(df.isnull().sum())
df2 = df.fillna(df.median())
