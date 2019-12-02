from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split

iris_dataset = load_iris()

x_train, x_test, y_train, y_test = train_test_split(iris_dataset['data'], iris_dataset['target'], test_size=0.3, random_state=0)

print(y_train)
print(y_test)

# 学習モデルの構築
from sklearn.neighbors import KNeighborsClassifier
knn = KNeighborsClassifier(n_neighbors=1)
knn.fit(x_train, y_train)

# 評価
import numpy as np
x_new = np.array([[5.0, 2.9, 1.0, 0.2]])
prediction1 = knn.predict(x_new)
print(iris_dataset['target_names'][prediction1])

y_pred = knn.predict(x_test)
print(y_pred)
print(y_test)
print(np.mean(y_pred == y_test))

