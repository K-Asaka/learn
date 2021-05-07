import pandas as pd

df = pd.read_csv('datafile/bike.tsv', sep = '\t')
print(df.head(3))

df2 = pd.read_csv('datafile/weather.csv', encoding = 'shift-jis')
print(df2.head(3))

temp = pd.read_json('datafile/temp.json')
print(temp.head(2))
print(temp.T)
