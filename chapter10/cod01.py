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
# df3['temp'].plot(kind = 'line')
# plt.show()

# df3[['temp', 'hum']].plot(kind = 'line')
# plt.show()

# df3['temp'].plot(kind = 'hist')
# df3['hum'].plot(kind = 'hist', alpha = 0.5)
# plt.show()

# インデックス220～240を抜き出して、折れ線グラフで表示
df3['atemp'].loc[220:240].plot(kind = 'line')
plt.show()

# atemp列の型をfloatに変換
df3['atemp'] = df3['atemp'].astype(float)
df3['atemp'] = df3['atemp'].interpolate()    # 欠損値を線形補間
df3.loc[225:235, 'atemp'].plot(kind = 'line')
plt.show()
