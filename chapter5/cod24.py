import pandas as pd
from sklearn import tree
from sklearn.model_selection import train_test_split
import pickle

with open('irismodel.pkl', 'rb') as f:
    model = pickle.load(f)

# 分岐条件の列を決める
print(model.tree_.feature)

# 分岐条件のしきい値を含む配列を返す
print(model.tree_.threshold)

# ノード番号1、3、4に到達したアヤメの種類ごとの数
print(model.tree_.value[1]) # ノード番号1に到達した時
print(model.tree_.value[3]) # ノード番号3に到達した時
print(model.tree_.value[4]) # ノード番号4に到達した時

# classes_でアヤメの種類とグループ番号の対応を調べる
print(model.classes_)


df = pd.read_csv('datafile/iris.csv')
colmean = df.mean()
df2 = df.fillna(colmean)
xcol = ['がく片長さ', 'がく片幅', '花弁長さ', '花弁幅']
x = df2[xcol]
t = df2['種類']
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.3, random_state = 0)

# 描画関数の仕様上、和名の特徴量を英字に直す
x_train.columns = ['gaku_nagasa', 'gaku_haba', 'kaben_nagasa', 'kaben_haba']

# 描画関数の利用
import matplotlib.pyplot as plt
from sklearn.tree import plot_tree

plt.figure(figsize=(15, 10))
# plot_tree関数で決定木を描画
plot_tree(model, feature_names = x_train.columns, filled = True)
plt.show()
