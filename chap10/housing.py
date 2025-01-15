import pandas as pd
df = pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/housing/housing.data'
                , header=None, sep='\\s+')
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


# 基本的な線形回帰モデル
class LinearRegressionGD(object):

    # 初期化を実行
    def __init__(self, eta=0.001, n_iter=20):
        self.eta = eta          # 学習率
        self.n_iter = n_iter    # トレーニング回数
    
    # トレーニングを実行
    def fit(self, X, y):
        self.w_ = np.zeros(1 + X.shape[1])  # 重みを初期化
        self.cost_ = []                     # コスト関数の値を初期化
        for i in range(self.n_iter):
            output = self.net_input(X)      # 活性化関数の出力を計算
            errors = (y - output)           # 誤差を計算
            self.w_[1:] += self.eta * X.T.dot(errors)   # 重みw_{1}以降を更新
            self.w_[0] += self.eta * errors.sum()       # 重みw_{0}を更新
            cost = (errors ** 2).sum() / 2.0            # コスト関数を計算
            self.cost_.append(cost)                     # コスト関数の値を格納
        return self
    
    # 総入力を計算
    def net_input(self, X):
        return np.dot(X, self.w_[1:]) + self.w_[0]
    
    # 予測値を計算
    def predict(self, X):
        return self.net_input(X)


X = df[['RM']].values
y = df['MEDV'].values
from sklearn.preprocessing import StandardScaler
sc_x = StandardScaler()
sc_y = StandardScaler()
X_std = sc_x.fit_transform(X)

y = y.reshape(-1, 1)
y_std = sc_y.fit_transform(y).flatten()

lr = LinearRegressionGD()
lr.fit(X_std, y_std)

# エポック数とコストの関係を表す折れ線グラフのプロット
plt.plot(range(1, lr.n_iter+1), lr.cost_)
plt.ylabel('SSE')
plt.xlabel('Epoch')
plt.show()


def lin_regplot(X, y, model):
    plt.scatter(X, y, c='blue')
    plt.plot(X, model.predict(X), color='red')
    return None

lin_regplot(X_std, y_std, lr)
plt.xlabel('Average number of rooms [RM] (standardized)')
plt.ylabel('Price in $1000\'s [MEDV] (standardized)')
plt.show()


num_rooms_std = sc_x.transform([[5.0]])
price_std = lr.predict(num_rooms_std)
price_std = np.array(price_std).reshape(-1, 1)
price_original = sc_y.inverse_transform(price_std)

print("Price in $1000's: %.3f" % price_original[0, 0])

print('Slope: %.3f' % lr.w_[1])
print('Intercept: %.3f' % lr.w_[0])
