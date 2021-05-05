import pandas as pd
from sklearn import tree
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt

df = pd.read_csv('datafile/Survived.csv')
print(df.head(2))

# Survived列のデータ
print(df['Survived'].value_counts())
