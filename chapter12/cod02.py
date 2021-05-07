import pandas as pd
from sklearn.model_selection import train_test_split

df = pd.read_csv('datafile/iris.csv')
print(df.head(2))

# 平均値に寄る欠損値の穴埋め
df_mean = df.mean()
train2 = df.fillna(df_mean)

# 特徴量と正解データに分割
x = train2.loc[ : , :'花弁幅']
t = train2['種類']

# 特徴量の標準化
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
new = sc.fit_transform(x)
