import pandas as pd

df = pd.read_csv('datafile/iris.csv')
print(df.head(3))

# array型の特定要素を参照
syurui = df['種類'].unique()
print(syurui[0])

# value_countsメソッドでデータの出現回数をカウント
print(df['種類'].value_counts())
