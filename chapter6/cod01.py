import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('datafile/cinema.csv')
print(df.head(3))

print(df.isnull().any(axis = 0))
# 欠損値を平均で補完して、df2に代入
df2 = df.fillna(df.mean())
# 穴埋めできたか確認
print(df2.isnull().any(axis = 0))

# SNS2とsalesの散布図の作成
df2.plot(kind = 'scatter', x = 'SNS2', y = 'sales')
plt.show()
