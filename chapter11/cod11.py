import pandas as pd
from sklearn.model_selection import train_test_split

df = pd.read_csv('Boston.csv')
df = df.fillna(df.mean())
x = df.loc[ : , 'ZN':'LSTAT']
t = df['PRICE']

x_train, x_test, y_train, y_test = train_test_split(x, t, test_size = 0.3, random_state = 0)
