#-*- encoding: utf-8
import theano
from theano import tensor as T
import numpy as np

def train_linreg(X_train, y_train, eta, epochs):

	costs = []
	# 配列の初期化
	eta0 = T.fscalar('eta0')	# float32型のスカラーのインスタンス
	y = T.fvector(name='y')		# float32型のベクトルのインスタンス
	X = T.fmatrix(name='X')		# float32型の行列のインスタンス
	# 重みwを関数内で参照可能な共有変数として作成
	w = theano.shared(np.zeros(shape=(X_train.shape[1] + 1),
								dtype=theano.config.floatX),
								name='w')
	# コストの計算
	net_input = T.dot(X, w[1:]) + w[0]	# 重みを用いて総入力を計算
	errors = y - net_input				# yと総入力の誤差
	cost = T.sum(T.pow(errors, 2))		# 誤差の2乗和

	# 重みの更新
	gradient = T.grad(cost, wrt=w)		# コストの勾配
	update = [(w, w - eta0 * gradient)]	# コストの勾配に学習率をかけて
										# 重みwを更新
	# モデルのコンパイル
	train = theano.function(inputs=[eta0],
							outputs=cost,
							updates=update,
							givens={X: X_train, y: y_train})
	for _ in range(epochs):
		costs.append(train(eta))

	return costs, w


def predict_linreg(X, w):
	Xt = T.matrix(name='X')
	net_input = T.dot(Xt, w[1:]) + w[0]
	predict = theano.function(inputs=[Xt],
								givens={w: w},
								outputs=net_input)
	return predict(X)
