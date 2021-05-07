import pandas as pd
from sklearn import tree

df = pd.read_csv('datafile/KvsT.csv')
x = df.loc[ : , '体重':'年代']
t = df['派閥']
model = tree.DecisionTreeClassifier(max_depth = 1, random_state = 0)
model.fit(x, t)
data = [[65, 20]]   # 予測用未知データ

print(model.predict(data))  # 予測派閥
print(model.predict_proba(data))   # 派閥の確率
