# 練習14-4
import pandas as pd

df = pd.read_csv('datafile/cinema.csv')
df = df.drop('cinema_id', axis = 1)
# 欠損値補完
df = df.fillna(df.mean())
# 可能なら外れ値の確認もするが割愛

from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
sc_df = sc.fit_transform(df)
sc_df = pd.DataFrame(sc_df, columns = df.columns)

# 累積寄与率を調べる
from sklearn.decomposition import PCA

model = PCA(whiten = True)
model.fit(sc_df)

total = []
for i in model.explained_variance_ratio_:
    if len(total) == 0:
        total.append(i)
    else:
        tmp = total[-1] + i
        total.append(tmp)

print(total)

model = PCA(whiten = True, n_components = 3)
model.fit(sc_df)
new = pd.DataFrame(model.transform(sc_df), columns = ['pc1', 'pc2', 'pc3'])
new_df = pd.concat([new, sc_df], axis = 1)
cor_df = new_df.corr()
print(cor_df.loc['pc1':'pc3', 'SNS1':])
