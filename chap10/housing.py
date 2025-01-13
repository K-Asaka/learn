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
cols = ['LSTAT', 'INDUS', 'NOX', 'RM', 'MEDV']
# 変数のペアの関係をプロット：dfはDataFrameオブジェクト、sizeは1面のインチサイズ
# sns.pairplot(df[cols], size=2.5)
sns.pairplot(df[cols], height=2.5)
plt.show()
