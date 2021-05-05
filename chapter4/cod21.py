import pickle
from sklearn import tree
import pandas as pd

with open('KinokoTakenoko.pkl', 'rb') as f:
    model2 = pickle.load(f)

suzuki = [[180, 75, 30]]
print(model2.predict(suzuki))
