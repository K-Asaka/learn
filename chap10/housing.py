import pandas as pd
df = pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/housing/housing.data'
                , header=None, sep='\s+')
df.columns = ['CRIM', 'ZN', 'INDUS', 'CHAS', 'NOX', 'RM', 'AGE', 'DIS', 'RAD',
              'TAX', 'PTRATIO', 'B', 'LSTAT', 'MEDV']
print(df.head())


import matplotlib.pyplot as plt
import seaborn as sns
# グラフのスタイルを指定(whitegridは白背景グリッド、notebookはデフォルトサイズ)
sns.set(style='whitegrid', context='notebook')
# seabornライブラリのスタイルを使用したくない場合
sns.reset_orig()
cols = ['LSTAT', 'INDUS', 'NOX', 'RM', 'MEDV']
# 変数のペアの関係をプロット：dfはDataFrameオブジェクト、sizeは1面のインチサイズ
# sns.pairplot(df[cols], size=2.5)
sns.pairplot(df[cols], height=2.5)
plt.show()


import numpy as np
cm = np.corrcoef(df[cols].values.T)     # ピアソンの積率相関係数を計算
sns.set(font_scale=1.5)                 # 全体のスケールとは別にフォントサイズを指定
hm = sns.heatmap(cm,                    # 第1引数の相関係数をもとにヒートマップを作製
                 cbar=True,             # カラーバーの表示
                 annot=True,            # データ値の表示
                 square=True,           # 各矩形の正方形化(縦と横のサイズを一致させる)
                 fmt='.2f',             # 数値などの表示形式
                 annot_kws={'size': 15},    # データ値のサイズの設定
                 yticklabels=cols,      # 行の目盛のラベル名
                 xticklabels=cols)      # 列の目盛のラベル名
plt.show()
