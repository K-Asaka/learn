import pandas as pd
from sklearn import tree
from sklearn.model_selection import train_test_split

df = pd.read_csv('datafile/iris.csv')

# 各列の平均値を計算して、colmeanに代入
colmean = df.mean()

# 平均値で欠損値を穴埋めしてdf2に代入
df2 = df.fillna(colmean)

# 欠損値があるか確認
print(df2.isnull().any(axis = 0))

# 特徴量と正解データを変数に代入
xcol = ['がく片長さ', 'がく片幅', '花弁長さ', '花弁幅']

x = df2[xcol]
t = df2['種類']

# モデルの作成
model = tree.DecisionTreeClassifier(max_depth = 2, random_state = 0)

# モデルの学習
model.fit(x, t)

# 学習済みモデルの正解率計算
print(model.score(x, t))

# 訓練データとテストデータに分割する
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.3, random_state = 0)

print(x_train.shape)
print(x_test.shape)

# 訓練データで再学習
model.fit(x_train, y_train)

# テストデータの予測結果と実際の答えが合致する正解率を計算
print(model.score(x_test, y_test))
