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


from sklearn.linear_model import LinearRegression
slr = LinearRegression()
slr.fit(X, y)
slope = slr.coef_[0].item()
intercept = slr.intercept_
# print('Slope: %.3f' % slr.coef_[0])
print('Slope: %.3f' % slope)
if np.ndim(intercept) > 0:
    intercept = intercept.item()
# print('Intercept: %.3f' % slr.intercept_)
print('Intercept: %.3f' % intercept)

lin_regplot(X, y, slr)
plt.xlabel('Average number of rooms [RM]')
plt.ylabel('Price in $1000\'s [MEDV]')
plt.show()


# "1"で構成された列ベクトルを追加
Xb = np.hstack((np.ones((X.shape[0], 1)), X))
y = y.reshape(-1, 1)
w = np.zeros(X.shape[1])
z = np.linalg.inv(np.dot(Xb.T, Xb))
w = np.dot(z, np.dot(Xb.T, y))
print('Slope: %.3f' % w[1, 0])
print('Intercept: %.3f' % w[0, 0])


from sklearn.linear_model import RANSACRegressor
# ロバスト回帰モデルのクラスをインスタンス化
ransac = RANSACRegressor(LinearRegression(),
                         max_trials=100,
                         min_samples=50,
                        #  residual_metric=lambda x: np.sum(np.abs(x), axis=1),
                         residual_threshold=5.0,
                         random_state=0)
ransac.fit(X, y)
inlier_mask = ransac.inlier_mask_               # 正常値を表す真偽値を取得
outlier_mask = np.logical_not(inlier_mask)      # 外れ値を表す真偽値を取得
line_X = np.arange(3, 10, 1)                    # 3から9までの整数値を作成
line_y_ransac = ransac.predict(line_X[:, np.newaxis])   # 予測値を計算
# 正常値をプロット
plt.scatter(X[inlier_mask], y[inlier_mask],
            c='blue', marker='o', label='Inliers')
# 外れ値をプロット
plt.scatter(X[outlier_mask], y[outlier_mask],
            c='lightgreen', marker='s', label='Outliers')
# 予測値をプロット
plt.plot(line_X, line_y_ransac, color='red')
plt.xlabel('Average number of rooms [RM]')
plt.ylabel('Price in $1000\'s [MEDV]')
plt.legend(loc='upper left')
plt.show()

# print('Slope: %.3f' % ransac.estimator_.coef_[0])
# print('Intercept: %.3f' % ransac.estimator_.intercept_)

print('Slope: %.3f' % ransac.estimator_.coef_[0].item())
print('Intercept: %.3f' % ransac.estimator_.intercept_.item())

# from sklearn.cross_validation import train_test_split
from sklearn.model_selection import train_test_split
X = df.iloc[:, :-1].values
y = df['MEDV'].values
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=0)
slr = LinearRegression()
slr.fit(X_train, y_train)
y_train_pred = slr.predict(X_train)
y_test_pred = slr.predict(X_test)

plt.scatter(y_train_pred, y_train_pred - y_train,
            c='blue', marker='o', label='Training data')
plt.scatter(y_test_pred, y_test_pred - y_test,
            c='lightgreen', marker='s', label='Test data')
plt.xlabel('Predicted values')
plt.ylabel('Residuals')
plt.legend(loc='upper left')
plt.hlines(y=0, xmin=-10, xmax=50, lw=2, color='red')
plt.xlim([-10, 50])
plt.show()

from sklearn.metrics import mean_squared_error
# 平均二乗誤差を出力
print('MSE train: %.3f, test: %.3f' % (mean_squared_error(y_train, y_train_pred),
                                       mean_squared_error(y_test, y_test_pred)))
# R^2(決定係数のスコアを出力)
from sklearn.metrics import r2_score
print('R^2 train: %.3f, test: %.3f' % (r2_score(y_train, y_train_pred),
                                       r2_score(y_test, y_test_pred)))


from sklearn.linear_model import Ridge
ridge = Ridge(alpha=1.0)    # L2ペナルティ項の影響度合いを表す値

from sklearn.linear_model import Lasso
lasso = Lasso(alpha=1.0)

from sklearn.linear_model import ElasticNet
elasticnet = ElasticNet(alpha=1.0, l1_ratio=0.5)
