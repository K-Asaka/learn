#-*- encoding: utf-8
import numpy as np

X = np.array([[1, 1.4, 1.5]])
w = np.array([0.0, 0.2, 0.4])

def net_input(X, w):
	z = X.dot(w)
	return z

def logistic(z):
	return 1.0 / (1.0 + np.exp(-z))

def logistic_activation(X, w):
	z = net_input(X, w)
	return logistic(z)

print('P(y=1|x) = %.3f' % logistic_activation(X, w)[0])


# W : array, sape = [n_output_units, n_hidden_units+1]
# 隠れ層 -> 出力層の重み行列
# 最初の列 (W[:][0] = 1)がバイアスユニットであることに注意
W = np.array([[1.1, 1.2, 1.3, 0.5],
			  [0.1, 0.2, 0.4, 0.1],
			  [0.2, 0.5, 2.1, 1.9]])
# A : array, shape = [n_hidden+1, n_samples]
# 隠れ層の活性化
# 最初の要素 (A[0][0] = 1)がバイアスユニットであることに注意
A = np.array([[1.0],
			  [0.1],
			  [0.3],
			  [0.7]])
# Z : array, shap = [n_output_units, n_samples]
# 出力層の総入力
Z = W.dot(A)
y_probas = logistic(Z)
print('Probabilities:\n', y_probas)

y_class = np.argmax(Z, axis=0)
print('predicted class label: %d' % y_class[0])
