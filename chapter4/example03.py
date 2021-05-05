import pandas as pd

# 練習4-3
df = pd.read_csv('datafile/ex1.csv')

# 練習4-4
print(df.index)

# 練習4-5
print(df.columns)

# 練習4-6
cols = ['x0', 'x2']
print(df[cols])
