from sklearn.datasets import load_digits

digits = load_digits()
print(digits.data)
print(digits.target)

import matplotlib.pyplot as plt

plt.figure(figsize=(3, 3))
plt.imshow(digits.images[0], cmap=plt.cm.gray_r)
plt.show()

from sklearn.model_selection import train_test_split

x_train, x_test, y_train, y_test = train_test_split(digits['data'], digits['target'], test_size=0.3, random_state=0)

from sklearn.neural_network import MLPClassifier

mlpc = MLPClassifier(max_iter=1000)
mlpc.fit(x_train, y_train)
pred = mlpc.predict(x_test)


import numpy as np

print(np.mean(pred == y_test))


from sklearn.metrics import confusion_matrix

print(confusion_matrix(y_test, pred, labels=digits['target_names']))
