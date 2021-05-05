import pandas as pd

df = pd.read_csv('datafile/iris.csv')
print(df.head(3))

syurui = df['種類'].unique()
print(syurui[0])

