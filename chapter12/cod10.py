import pandas as pd
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt

df = pd.read_csv('datafile/Survived.csv')
print(df.head(2))

jo1 = df['Pclass'] == 1
jo2 = df['Survived'] == 0
jo3 = df['Age'].isnull()
df.loc[(jo1) & (jo2) & (jo3), 'Age'] = 43

jo2 = df['Survived'] == 1
df.loc[(jo1) & (jo2) & (jo3), 'Age'] = 35

jo1 = df['Pclass'] == 2
jo2 = df['Survived'] == 0
jo3 = df['Age'].isnull()
df.loc[(jo1) & (jo2) & (jo3), 'Age'] = 26

jo2 = df['Survived'] == 1
df.loc[(jo1) & (jo2) & (jo3), 'Age'] = 20

jo1 = df['Pclass'] == 3
jo2 = df['Survived'] == 0
jo3 = df['Age'].isnull()
df.loc[(jo1) & (jo2) & (jo3), 'Age'] = 43

jo2 = df['Survived'] == 1
df.loc[(jo1) & (jo2) & (jo3), 'Age'] = 35

# 特徴量として利用する列のリスト
col = ['Pclass', 'Age', 'SibSp', 'Parch', 'Fare']

x = df[col]
t = df['Survived']

# Sex列は文字の列なのでダミー変数化
dummy = pd.get_dummies(df['Sex'], drop_first = True)
x = pd.concat([x, dummy], axis = 1)
print(x.head(2))

# ランダムフォレストのインポート
from sklearn.ensemble import RandomForestClassifier
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)
model = RandomForestClassifier(n_estimators = 200, random_state = 0)

model.fit(x_train, y_train)
print(model.score(x_train, y_train))
print(model.score(x_test, y_test))

from sklearn import tree
model2 = tree.DecisionTreeClassifier(random_state = 0)
model2.fit(x_train, y_train)
print(model2.score(x_train, y_train))
print(model2.score(x_test, y_test))

importance = model.feature_importances_     # 特徴量重要土
# 列との対応がわかりやすいようにシリーズ変換
print(pd.Series(importance, index = x_train.columns))

# アダブーストのインポート
from sklearn.ensemble import AdaBoostClassifier
# ベースとなるモデル
from sklearn.tree import DecisionTreeClassifier

x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)
# 最大の深さ5の決定木を何個も作っていく
base_model = DecisionTreeClassifier(random_state = 0, max_depth = 5)

# 決定木を500個作成
model = AdaBoostClassifier(n_estimators = 500, random_state = 0, base_estimator = base_model)
model.fit(x_train, y_train)     # 学習

print(model.score(x_train, y_train))
print(model.score(x_test, y_test))

# データの読み込み
df = pd.read_csv('datafile/cinema.csv')
df = df.fillna(df.mean())
x = df.loc[ : , 'SNS1':'original']
t = df['sales']
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)

# ランダムフォレスト回帰
from sklearn.ensemble import RandomForestRegressor
# 100個のモデルで並列学習
model = RandomForestRegressor(random_state = 0, n_estimators = 100)
model.fit(x_train, y_train)
print(model.score(x_test, y_test))      # 決定木係数

# アダブースト回帰
from sklearn.ensemble import AdaBoostRegressor
# ベースモデルとしての回帰木
from sklearn.tree import DecisionTreeRegressor
base = DecisionTreeRegressor(random_state = 0, max_depth = 3)

# 100個のモデルで逐次学習
model = AdaBoostRegressor(random_state = 0, n_estimators = 100, base_estimator = base)
model.fit(x_train, y_train)
print(model.score(x_test, y_test))      # 決定木係数
