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
