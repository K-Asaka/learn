# 練習15-1
import pandas as pd

df = pd.read_csv('datafile/Survived.csv')

# 練習15-2
df = df.drop(['PassengerId', 'Ticket', 'Cabin', 'Embarked'], axis = 1)

# 練習15-3
df = df.fillna(df.mean())

# 練習15-4
dummy = pd.get_dummies(df['Sex'], drop_first = True)
df = pd.concat([df, dummy], axis = 1)
df = df.drop('Sex', axis = 1)
