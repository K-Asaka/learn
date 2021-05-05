from sklearn import tree
import pandas as pd

df = pd.read_csv('datafile/KvsT.csv')

# 特徴量の列を参照してxに代入
xcol = ['身長', '体重', '年代']
x = df[xcol]

# 正解データ(派閥)を参照して、tに代入
t = df['派閥']

# モデルの準備(未学習)
model = tree.DecisionTreeClassifier(random_state = 0)
# 学習の実行(x、tは事前に定義済みの特徴量と正解ラベル)
print(model.fit(x, t))
