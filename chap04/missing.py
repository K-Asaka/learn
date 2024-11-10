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
