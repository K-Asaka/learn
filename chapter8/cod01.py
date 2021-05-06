import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

df = pd.read_csv('datafile/Boston.csv')
print(df.head(2))

# ダミー変数化
print(df['CRIME'].value_counts())
crime = pd.get_dummies(df['CRIME'], drop_first = True)
df2 = pd.concat([df, crime], axis = 1)
df2 = df2.drop(['CRIME'], axis = 1)
print(df2.head(2))

# 訓練データ&検証データとテストデータに分割する
train_val, test = train_test_split(df2, test_size = 0.2, random_state = 0)

# 欠損値を確認する
print(train_val.isnull().sum())

# 欠損値を平均値で穴埋めする
train_val_mean = train_val.mean()   # 各列の平均値の計算
train_val2 = train_val.fillna(train_val_mean)   # 平均値で穴埋め

# 外れ値の処理
# colname = train_val2.columns
# for name in colname:
#     train_val2.plot(kind = 'scatter', x = name, y = 'PRICE')
# plt.show()

# 外れ値が存在するインデックスを確認する
# RMの外れ値
out_line1 = train_val2[(train_val2['RM'] < 6) & (train_val2['PRICE'] > 40)].index
# PTRATIOの外れ値
out_line2 = train_val2[(train_val2['PTRATIO'] > 18) & (train_val2['PRICE'] > 40)].index
print(out_line1, out_line2)
# 外れ値を削除する
train_val3 = train_val2.drop([76], axis = 0)

# 絞り込んだ列以外を取り除く
col = ['INDUS', 'NOX', 'RM', 'PTRATIO', 'LSTAT', 'PRICE']
train_val4 = train_val3[col]
print(train_val4.head(3))

# 列同士の相関係数を調べる
print(train_val4.corr())
# 各列とPRICE列との相関係数を見る
train_cor = train_val4.corr()['PRICE']
print(train_cor)

# abs関数で絶対値に変換
print(abs(1))
print(abs(-2))

# mapメソッドで要素に関数を適用する
se = pd.Series([1, -2, 3, -4])  # シリーズの作成
# seの各要素にabs関数を適応させた結果をシリーズ化
print(se.map(abs))

# 相関行列のPRICE列との相関係数を絶対値に変換する
abs_cor = train_cor.map(abs)
print(abs_cor)
# 降順に並び替える
print(abs_cor.sort_values(ascending = False))

# 訓練データと検証データに分割する
col = ['RM', 'LSTAT', 'PTRATIO']
x = train_val4[col]
t = train_val4[['PRICE']]
# 訓練データと検証データに分割
x_train, x_val, y_train, y_val = train_test_split(x, t, test_size = 0.2, random_state = 0)

# データの標準化
from sklearn.preprocessing import StandardScaler

sc_model_x = StandardScaler()
sc_model_x.fit(x_train)

# 各列のデータを標準化してsc_xに代入
sc_x = sc_model_x.transform(x_train)
print(sc_x)     # 表示

# 平均値0を確認する
# array型だと見づらいのでデータフレームに変換
tmp_df = pd.DataFrame(sc_x, columns = x_train.columns)
# 平均値の計算
print(tmp_df.mean())
# 標準偏差1を確認する
print(tmp_df.std())

# 正解データを標準化する
sc_model_y = StandardScaler()
sc_model_y.fit(y_train)

sc_y = sc_model_y.transform(y_train)

model = LinearRegression()
model.fit(sc_x, sc_y)   # 標準化済みの訓練データで学習

# 標準化前の検証データを使ってしまうと正しく評価できない
print(model.score(x_val, y_val))

# 訓練データの平均値や標準偏差の情報を元に変換する
sc_x_val = sc_model_x.transform(x_val)
sc_y_val = sc_model_y.transform(y_val)
# 標準化した検証データで決定係数を計算
print(model.score(sc_x_val, sc_y_val))

# 以下、やってはいけない間違いのコード
# 検証データでの平均値と標準偏差を調べて、その値で標準化してはいけない
# sc_model_x2 = StandardScaler()
# sc_model_x2.fit(x_val)    # ※
# sc_x_val = sc_model_x2.transform(x_val)
# sc_model_y2 = StandardScaler()
# sc_model_y2.fit(y_val)    # ※
# sc_y_val = sc_model_y2.transform(y_val)
# print(model.score(sc_x_val, sc_y_val))

# learn関数の定義
def learn(x, t):
    x_train, x_val, y_train, y_val = train_test_split(x, t, test_size = 0.2, random_state = 0)
    # 訓練データを標準化
    sc_model_x = StandardScaler()
    sc_model_y = StandardScaler()
    sc_model_x.fit(x_train)
    sc_x_train = sc_model_x.transform(x_train)
    sc_model_y.fit(y_train)
    sc_y_train = sc_model_y.transform(y_train)
    # 学習
    model = LinearRegression()
    model.fit(sc_x_train, sc_y_train)

    # 検証データを標準化
    sc_x_val = sc_model_x.transform(x_val)
    sc_y_val = sc_model_y.transform(y_val)
    # 訓練データと検証データの決定係数計算
    train_score = model.score(sc_x_train, sc_y_train)
    val_score = model.score(sc_x_val, sc_y_val)
    return train_score, val_score

x = train_val3.loc[ : , ['RM', 'LSTAT', 'PTRATIO']]
t = train_val3[['PRICE']]

s1, s2 = learn(x, t)
print(s1, s2)

x = train_val3.loc[ : , ['RM', 'LSTAT', 'PTRATIO', 'INDUS']]
t = train_val3[['PRICE']]
s1, s2 = learn(x, t)
print(s1, s2)
