import pandas as pd
# サンプルデータを生成(Tシャツの色・サイズ・価格・クラスラベル)
df = pd.DataFrame([
    ['green', 'M', 10.1, 'class1'],
    ['red', 'L', 13.5, 'class2'],
    ['blue', 'XL', 15.3, 'class1']])
# 列名を設定
df.columns = ['color', 'size', 'price', 'classlabel']
print(df)

# Tシャツのサイズと整数を対応させるディクショナリを生成
size_mapping = {'XL': 3, 'L': 2, 'M': 1}
# Tシャツのサイズを整数に変換
df['size'] = df['size'].map(size_mapping)
print(df)


import numpy as np
# クラスラベルと整数を対応させるディクショナリを生成
class_mapping = {label:idx for idx, label in enumerate(np.unique(df['classlabel']))}
print(class_mapping)

# クラスラベルを整数に変換
df['classlabel'] = df['classlabel'].map(class_mapping)
print(df)

# 整数とクラスラベルを対応させるディクショナリを生成
inv_class_mapping = {v: k for k, v in class_mapping.items()}
# 整数からクラスラベルに変換
df['classlabel'] = df['classlabel'].map(inv_class_mapping)
print(df)

from sklearn.preprocessing import LabelEncoder
# ラベルエンコーダのインスタンスを生成
class_le = LabelEncoder()
# クラスラベルから整数に変換
y = class_le.fit_transform(df['classlabel'].values)
print(y)

# クラスラベルを文字列に戻す
print(class_le.inverse_transform(y))


# Tシャツの色、サイズ、価格を抽出
X = df[['color', 'size', 'price']].values
color_le = LabelEncoder()
X[:, 0] = color_le.fit_transform(X[:, 0])
print(X)

from sklearn.preprocessing import OneHotEncoder
from sklearn.compose import ColumnTransformer
# one-hotエンコーダの生成
#ohe = OneHotEncoder(categorical_features=[0])
ct = ColumnTransformer([("test", OneHotEncoder(), [0])], remainder='passthrough')
# one-hotエンコーディングを実行
#print(ohe.fit_transform(X).toarray())
print(ct.fit_transform(X))

# one-hotエンコーディングを実行
print(pd.get_dummies(df[['price', 'color', 'size']]))
