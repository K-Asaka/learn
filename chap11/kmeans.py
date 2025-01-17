from sklearn.datasets import make_blobs
X, y = make_blobs(n_samples=150,        # サンプル点の総数
                  n_features=2,         # 特徴量の個数
                  centers=3,            # クラスタの個数
                  cluster_std=0.5,      # クラスタ内の標準偏差
                  shuffle=True,         # サンプルをシャッフル
                  random_state=0)       # 乱数生成器の状態を指定
import matplotlib.pyplot as plt
plt.style.use('default')
plt.scatter(X[:, 0], X[:, 1], c='white', marker='o', s=50, edgecolor='black')
plt.grid()
plt.show()

from sklearn.cluster import KMeans
km = KMeans(n_clusters=3,           # クラスタの個数
            init='random',          # セントロイドの初期値をランダムに選択
            n_init=10,              # 異なるセントロイドの初期値を用いたk-meansアルゴリズムの実行回数
            max_iter=300,           # k-meansアルゴリズム内部の最大イテレーション回数
            tol=1e-04,              # 収束と判定するための相対的な許容誤差
            random_state=0)         # セントロイドの初期化に用いる乱数生成器の状態
y_km = km.fit_predict(X)
