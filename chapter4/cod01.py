import pandas as pd

data = {
    'Aの労働時間' : [160, 160],
    'Bの労働時間' : [161, 175]
}

# データフレームの作成
df = pd.DataFrame(data)
print(df)

# データフレームのデータ型を確認
print(type(df))
# 行数や列数を調べる
print(df.shape)

# インデクスの変更
df.index = ['4月', '5月']
print(df)

# 列名の変更
df.columns = ['Aの労働(h)', 'Bの労働(h)']
print(df)

print(df.index)
print(df.columns)

