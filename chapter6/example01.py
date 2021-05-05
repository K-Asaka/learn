# 練習6-1
import pandas as pd

df = pd.read_csv('datafile/ex3.csv')

# 練習6-2
print(df.head(5))

# 練習6-4
print(df.isnull().sum())
df2 = df.fillna(df.median())

# 練習6-5
import matplotlib.pyplot as plt
#df2.plot(kind = 'scatter', x = 'x0', y = 'target')
#plt.show()

# 練習6-6
for name in df.columns:
    if name == 'target':
        continue
    df2.plot(kind = 'scatter', x = name, y = 'target')
plt.show()
