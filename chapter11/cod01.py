import pandas as pd
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler

df = pd.read_csv('datafile/Boston.csv')
df = df.fillna(df.mean())
df = df.drop([76], axis = 0)

t = df[['PRICE']]
x = df.loc[ : , ['RM', 'PTRATIO', 'LSTAT']]

sc = StandardScaler()
sc_x = sc.fit_transform(x)
sc2 = StandardScaler()
sc_t = sc2.fit_transform(t)

from sklearn.preprocessing import PolynomialFeatures

pf = PolynomialFeatures(degree = 2, include_bias = False)
pf_x = pf.fit_transform(sc_x)
print(pf_x.shape)

print(pf.get_feature_names())

from sklearn.linear_model import LinearRegression

x_train, x_test, y_train, y_test = train_test_split(pf_x, sc_t, test_size = 0.3, random_state = 0)
model = LinearRegression()
model.fit(x_train, y_train)

print(model.score(x_train, y_train))
print(model.score(x_test, y_test))


from sklearn.linear_model import Ridge
# モデルの作成
ridgeModel = Ridge(alpha = 10)
ridgeModel.fit(x_train, y_train)
print(ridgeModel.score(x_train, y_train))
print(ridgeModel.score(x_test, y_test))

maxScore = 0
maxIndex = 0
# range関数により整数列を1～2000生成
for i in range(1, 2001):
    num = i / 100
    ridgeModel = Ridge(random_state = 0, alpha = num)
    ridgeModel.fit(x_train, y_train)

    result = ridgeModel.score(x_test, y_test)
    if result > maxScore:
        maxScore = result
        maxIndex = num

print(maxIndex, maxScore)

print(sum(abs(model.coef_)[0])) # 線形回帰の係数(絶対値)の合計
print(sum(abs(ridgeModel.coef_)[0]))    # リッジ回帰の合計
