# 練習15-1
import pandas as pd

df = pd.read_csv('datafile/Survived.csv')

# 練習15-2
df = df.drop(['PassengerId', 'Ticket', 'Cabin', 'Embarked'], axis = 1)
