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
