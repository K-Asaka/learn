import pandas as pd
import pickle

with open('cinema.pkl', 'rb') as f:
    model = pickle.load(f)

print(model.coef_)      # 計算式の係数の表示
print(model.intercept_) # 計算式の切片の表示


df = pd.read_csv('datafile/cinema.csv')
df2 = df.fillna(df.mean())
no = df2[(df2['SNS2'] > 1000) & (df2['sales'] < 8500)].index
df3 = df2.drop(no, axis = 0)
x = df3.loc[ : , 'SNS1':'original']
t = df3['sales']
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)

tmp = pd.DataFrame(model.coef_)     # データフレームの作成
tmp.index = x_train.columns         # 列名をインデックスに指定
print(tmp)
