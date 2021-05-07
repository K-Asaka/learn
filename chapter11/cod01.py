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
