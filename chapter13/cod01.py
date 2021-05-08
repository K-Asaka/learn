import pandas as pd
# 欠損値があるままでは学習できないので欠損値処理だけ行う
df = pd.read_csv('datafile/cinema.csv')
df = df.fillna(df.mean())
x = df.loc[ : , 'SNS1':'original']
t = df['sales']
from sklearn.linear_model import LinearRegression
model = LinearRegression()
model.fit(x, t)

from sklearn.metrics import mean_squared_error
# 訓練データでのMSE値
pred = model.predict(x)

mse = mean_squared_error(pred, t)
print(mse)
