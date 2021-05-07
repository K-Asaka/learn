import pandas as pd
from sklearn.model_selection import train_test_split

df = pd.read_csv('datafile/Boston.csv')
df = df.fillna(df.mean())
x = df.loc[ : , 'ZN':'LSTAT']
t = df['PRICE']

x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.3, random_state = 0)

from sklearn.tree import DecisionTreeRegressor

# 木の深さの最大を10と設定
model = DecisionTreeRegressor(max_depth = 10, random_state = 0)
model.fit(x_train, y_train)
print(model.score(x_test, y_test))

print(pd.Series(model.feature_importances_, index = x.columns))
