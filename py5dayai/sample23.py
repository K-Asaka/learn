from sklearn.datasets import load_digits

digits = load_digits()
print(digits.data)
print(digits.target)

import matplotlib.pyplot as plt

plt.figure(figsize=(3, 3))
plt.imshow(digits.images[0], cmap=plt.cm.gray_r)
plt.show()
