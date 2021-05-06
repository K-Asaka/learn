import pandas as pd

data = {'A':[1, 2], 'B':[10, 20], 'C':[100, 200]}
df = pd.DataFrame(data, index = ['X', 'Y'])
# 0行目0列目
print(df.iloc[0, 0])
print('##########')
# 1行目以降、0列目から末尾列の手前まで
print(df.iloc[1:, 0:-1])
print('##########')
