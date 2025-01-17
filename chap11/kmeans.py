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


plt.scatter(X[y_km==0,0],       # グラフのxの値
            X[y_km==0,1],       # グラフのyの値
            s=50,               # プロットのサイズ
            c='lightgreen',     # プロットの色
            marker='s',         # マーカーの形
            label='cluster 1')  # ラベル名
plt.scatter(X[y_km==1,0],
            X[y_km==1,1],
            s=50,
            c='orange',
            marker='o',
            label='cluster 2')
plt.scatter(X[y_km==2,0],
            X[y_km==2,1],
            s=50,
            c='lightblue',
            marker='v',
            label='cluster 3')
plt.scatter(km.cluster_centers_[:,0],
            km.cluster_centers_[:,1],
            s=250,
            marker='*',
            c='red',
            label='centroids')
plt.legend()
plt.grid()
plt.show()
