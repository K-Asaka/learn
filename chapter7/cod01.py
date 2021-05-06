import pandas as pd
from sklearn import tree
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt

# x:特徴量 t:正解データ depth:木の深さ
def learn(x, t, depth = 3):
    x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)
    model = tree.DecisionTreeClassifier(max_depth = depth, random_state = 0, class_weight = 'balanced')
    model.fit(x_train, y_train)

    score = model.score(X = x_train, y = y_train)
    score2 = model.score(X = x_test, y = y_test)
    return round(score, 3), round(score2, 3), model

df = pd.read_csv('datafile/Survived.csv')
print(df.head(2))

# Survived列のデータ
print(df['Survived'].value_counts())

# 欠損値の処理
print(df.isnull().sum())
print(df.shape)

# Age列とEmbarked列の穴埋め
df['Age'] = df['Age'].fillna(df['Age'].mean())
df['Embarked'] = df['Embarked'].fillna(df['Embarked'].mode())

# 特徴量として利用する列のリスト
col = ['Pclass', 'Age', 'SibSp', 'Parch', 'Fare']
x = df[col]
t = df['Survived']

# 訓練データとテストデータに分割する
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.2, random_state = 0)
print(x_train.shape)


for j in range(1, 15):  # jは木の深さ(1～14が入る)
    # xは特徴量、tは正解データ
    train_score, test_score, model = learn(x, t, depth = j)
    sentence = '訓練データの正解率{}'
    sentence2 = 'テストデータの正解率{}'
    total_sentence = '深さ{}:' + sentence + sentence2
    print(total_sentence.format(j, train_score, test_score))

df2 = pd.read_csv('datafile/Survived.csv')
print(df2['Age'].mean())
print(df2['Age'].median())

# ピボットテーブルによる集計
# 小グループ作成の基準となる列(基準軸)を指定
print(df2.groupby('Survived').mean()['Age'])

# Pclass列で集計
print(df2.groupby('Pclass').mean()['Age'])

# ピボットテーブル機能を使う
# Survived列とPclass列の2つの列を使った集計(クロス集計)
# 平均値
print(pd.pivot_table(df2, index = 'Survived', columns = 'Pclass', values = 'Age'))
# 各グループの年齢の最大値
print(pd.pivot_table(df2, index = 'Survived', columns = 'Pclass', values = 'Age', aggfunc = max))

# Age列の欠損値の行を抜き出す(欠損であればTrue)
is_null = df2['Age'].isnull()

# Pclass 1 に関する埋め込み(値はクロス集計の平均値を利用)
df2.loc[(df['Pclass'] == 1) & (df['Survived'] == 0) & (is_null), 'Age'] = 43
df2.loc[(df['Pclass'] == 1) & (df['Survived'] == 1) & (is_null), 'Age'] = 35

# Pclass 2 に関する埋め込み
df2.loc[(df['Pclass'] == 2) & (df['Survived'] == 0) & (is_null), 'Age'] = 33
df2.loc[(df['Pclass'] == 2) & (df['Survived'] == 1) & (is_null), 'Age'] = 25

# Pclass 3 に関する埋め込み
df2.loc[(df['Pclass'] == 3) & (df['Survived'] == 0) & (is_null), 'Age'] = 26
df2.loc[(df['Pclass'] == 3) & (df['Survived'] == 1) & (is_null), 'Age'] = 20

# 特徴量として利用する列のリスト
col = ['Pclass', 'Age', 'SibSp', 'Parch', 'Fare']
x = df2[col]
t = df2['Survived']

for j in range(1, 15):
    s1, s2, m = learn(x, t, depth = j)
    sentence = '深さ{}:訓練データの精度{}::テストデータの精度{}'
    print(sentence.format(j, s1, s2))
