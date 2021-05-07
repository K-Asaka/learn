import pandas as pd

df = pd.read_csv('datafile/bike.tsv', sep = '\t')
print(df.head(3))

df2 = pd.read_csv('datafile/weather.csv')
print(df2.head(3))

weather = pd.read_csv('datafile/weather.csv', encoding = 'shift-jis')

temp = pd.read_json('datafile/temp.json')
print(temp.head(2))
print(temp.T)

df2 = df.merge(weather, how = 'inner', on = 'weather_id')
print(df2.head(2))

print(df2.groupby('weather').mean()['cnt'])

temp = temp.T
print(temp.loc[199:201])

print(df2[df2['dteday'] == '2011-07-20'])

df3 = df2.merge(temp, how = 'left', on = 'dteday')
print(df3[df3['dteday'] == '2011-07-20'])

import matplotlib.pyplot as plt
df3['temp'].plot(kind = 'line')
plt.show()

df3[['temp', 'hum']].plot(kind = 'line')
plt.show()
