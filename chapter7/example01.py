# 練習7-1
import pandas as pd

df = pd.read_csv('datafile/ex4.csv')
print(df.head(3))

# 練習7-2
print(df['sex'].mean())
