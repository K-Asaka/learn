import pandas as pd
# サンプルデータを生成(Tシャツの色・サイズ・価格・クラスラベル)
df = pd.DataFrame([
    ['green', 'M', 10.1, 'class1'],
    ['red', 'L', 13.5, 'class2'],
    ['blue', 'XL', 15.3, 'class1']])
# 列名を設定
df.columns = ['color', 'size', 'price', 'classlabel']
print(df)

