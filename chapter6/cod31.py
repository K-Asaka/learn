import pickle

with open('cinema.pkl', 'rb') as f:
    model = pickle.load(f)

print(model.coef_)      # 計算式の係数の表示
print(model.intercept_) # 計算式の切片の表示
