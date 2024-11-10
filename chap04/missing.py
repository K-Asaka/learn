import pandas as pd
from io import StringIO
# サンプルデータを作成
csv_data = '''A,B,C,D
1.0,2.0,3.0,4.0
5.0,6.0,,8.0
10.0,11.0,12.0,'''
# Python2.7を使用している場合は文字列をunicodeに変換する必要がある
# csv_data = unicode(csv_data)
# サンプルデータを読み込む
df = pd.read_csv(StringIO(csv_data))
print(df)

# 各特徴量の欠測値をカウント
print(df.isnull().sum())


# 欠測値を含む行を削除
print(df.dropna())

# 欠測値を含む列を削除
print(df.dropna(axis=1))

# すべての列がNaNである行だけを削除
print(df.dropna(how='all'))

# 非NaN値が4つ未満の行を削除
print(df.dropna(thresh=4))

# 特定の列(この場合は'C')にNaNが含まれている行だけを削除
print(df.dropna(subset=['C']))


#from sklearn.preprocessing import Imputer
from sklearn.impute import SimpleImputer
# 欠測値補完のインスタンスを生成(平均値補完)
#imr = Imputer(missing_values='NaN', strategy='mean', axis=0)
imr = SimpleImputer()
# データを適合
imr = imr.fit(df)
# 補完を実行
imputed_data = imr.transform(df.values)
print(imputed_data)
