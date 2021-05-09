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

import math
print(math.sqrt(mse))   # RMSEの計算

from sklearn.metrics import mean_absolute_error
yosoku = [2, 3, 5, 7, 11, 13]   # 予測結果をリストで作成
target = [3, 5, 8, 11, 16, 19]  # 実際の結果をリストで作成

mse = mean_squared_error(yosoku, target)
print('rmse:{}'.format(math.sqrt(mse)))
print('mae:{}'.format(mean_absolute_error(yosoku, target)))

print('外れ値の混入')
yosoku = [2, 3, 5, 7, 11, 13, 46]   # 実際には23だけど46と予測
target = [3, 5, 8, 11, 16, 19, 23]
mse = mean_squared_error(yosoku, target)
print('rmse:{}'.format(math.sqrt(mse)))
print('mae:{}'.format(mean_absolute_error(yosoku, target)))

# データの準備
df = pd.read_csv('datafile/Survived.csv')
df = df.fillna(df.mean())

x = df[['Pclass', 'Age']]
t = df['Survived']

# モデルの準備
from sklearn import tree
model = tree.DecisionTreeClassifier(max_depth = 2, random_state = 0)
model.fit(x, t)

from sklearn.metrics import classification_report
pred = model.predict(x)
out_put = classification_report(y_pred = pred, y_true = t)
print(out_put)

out_put = classification_report(y_pred = pred, y_true = t, output_dict = True)
# out_putをデータフレームに変換
print(pd.DataFrame(out_put))

df = pd.read_csv('datafile/cinema.csv')
# 学習できないので欠損値処理だけ行う
df = df.fillna(df.mean())
x = df.loc[ : , 'SNS1':'original']
t = df['sales']

from sklearn.model_selection import KFold
kf = KFold(n_splits = 3, shuffle = True, random_state = 0)

from sklearn.model_selection import cross_validate
model = LinearRegression()
result = cross_validate(model, x, t, cv = kf, scoring = 'r2', return_train_score = True)
print(result)

print(sum(result['test_score']) / len(result['test_score']))
