import pandas as pd
from sklearn import tree
from sklearn.model_selection import train_test_split
import pickle

with open('irismodel.pkl', 'rb') as f:
    model = pickle.load(f)

# 分岐条件の列を決める
print(model.tree_.feature)

# 分岐条件のしきい値を含む配列を返す
print(model.tree_.threshold)
