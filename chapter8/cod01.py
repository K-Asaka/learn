import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

df = pd.read_csv('datafile/Boston.csv')
print(df.head(2))

# ダミー変数化
print(df['CRIME'].value_counts())
crime = pd.get_dummies(df['CRIME'], drop_first = True)
df2 = pd.concat([df, crime], axis = 1)
df2 = df2.drop(['CRIME'], axis = 1)
print(df2.head(2))

# 訓練データ&検証データとテストデータに分割する
train_val, test = train_test_split(df2, test_size = 0.2, random_state = 0)
