import pandas as pd
# 欠損値があるままでは学習できないので欠損値処理だけ行う
df = pd.read_csv('datafile/cinema.csv')
df = df.fillna(df.mean())
x = df.loc[ : , 'SNS1':'original']
t = df['sales']
from sklearn.linear_model import LinearRegression
model = LinearRegression()
model.fit(x, t)
