import pandas as pd
df = pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/breast-cancer-wisconsin/wdbc.data', header=None)

from sklearn.preprocessing import LabelEncoder
X = df.loc[:, 2:].values
y = df.loc[:, 1].values
le = LabelEncoder()
y = le.fit_transform(y)

print(le.transform(['M', 'B']))

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = \
    train_test_split(X, y, test_size=0.20, random_state=1)

from sklearn.preprocessing import StandardScaler
from sklearn.decomposition import PCA
from sklearn.linear_model import LogisticRegression
from sklearn.pipeline import Pipeline
# 連結する処理としてスケーリング、主成分分析、ロジスティック回帰を指定
pipe_lr = Pipeline([('scl', StandardScaler()), ('pca', PCA(n_components=2)),
                    ('clf', LogisticRegression(random_state=1))])
pipe_lr.fit(X_train, y_train)
print('Test Accuracy: %.3f' % pipe_lr.score(X_test, y_test))

import numpy as np
from sklearn.model_selection import StratifiedKFold
# 分割元データ、分割数、乱数生成器の状態を指定し、
# 層化k分割交差検証イテレータを表すStratifiedKFoldクラスのインスタンス化
# kfold = StratifiedKFold(y=y_train, n_folds=10, random_state=1)
kfold = StratifiedKFold(n_splits=10, random_state=1, shuffle=True).split(X_train, y_train)
scores = []
# イテレータのインデックスと要素をループ処理：(上から順に)
#       データをモデルに適合
#       テストデータの正解率を算出
#       リストに正解率を追加
#       分割の番号、0以上の要素数、正解率を出力
# for k, (train, test) in enumerate(kfold):
for k, (train, test) in enumerate(kfold):
    pipe_lr.fit(X_train[train], y_train[train])
    score = pipe_lr.score(X_train[test], y_train[test])
    scores.append(score)
    print('Fold: %s, Class dist.: %s, Acc: %.3f' %
          (k+1, np.bincount(y_train[train]), score))
# 正解率の平均と標準偏差を出力
print('CV accuracy: %.3f +/- %.3f' % (np.mean(scores), np.std(scores)))

from sklearn.model_selection import cross_val_score
# 交差検証のcross_val_score関数でモデルの正解率を算出
# 推定器estimator、トレーニングデータX、予測値y、分割数cv、CPU数n_jobsを指定
scores = cross_val_score(estimator=pipe_lr,
                         X=X_train,
                         y=y_train,
                         cv=10,
                         n_jobs=1)
print('CV accuracy scores: %s' % scores)
print('CV accuracy: %.3f +/- %0.3f' % (np.mean(scores), np.std(scores)))
