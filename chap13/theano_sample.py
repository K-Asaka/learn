#-*- ecoding: utf-8
import theano
from theano import tensor as T

# 初期化：scalarメソッドではスカラー(単純な配列)を生成
x1 = T.scalar()
w1 = T.scalar()
w0 = T.scalar()
z1 = w1 * x1 + w0

# コンパイル
net_input = theano.function(inputs=[w1, x1, w0], outputs=z1)

# 実行
print('Net input: %.2f' % net_input(2.0, 1.0, 0.5))


print(theano.config.floatX)

theano.config.floatX = 'float32'
print(theano.config.floatX)
# bash
# export THEANO_FLAGS=floatX=float32
# THEANO_FLAGS=floatX=float32 python <Pythonスクリプト>

print(theano.config.device)
# THEANO_FLAGS=device=cpu,floatX=float64 python <Pythonスクリプト>
# THEANO_FLAGS=device=gpu,floatX=float32 python <Pythonスクリプト>

# .theanorc
# echo -e "\n[global]\nfloatX=float32\ndevice=gpu\n" >> ~/.theanorc


import numpy as np

# 初期化
# Theanoを64ビットモードで実行している場合は、
# fmatrixの代わりにdmatrixを使用する必要がある
x = T.fmatrix(name='x')
#x = T.dmatrix(name='x')
x_sum = T.sum(x, axis=0)

# コンパイル
calc_sum = theano.function(inputs=[x], outputs=x_sum)

# 実行(Pythonリスト)
ary = [[1, 2, 3], [1, 2, 3]]
print('Column sum:', calc_sum(ary))

# 実行(NumPy配列)
ary = np.array([[1, 2, 3], [1, 2, 3]], dtype=theano.config.floatX)
print('Column sum:', calc_sum(ary))


# 初期化
x = T.fmatrix('x')
w = theano.shared(np.asarray([[0.0, 0.0, 0.0]], dtype=theano.config.floatX))
z = x.dot(w.T)
update = [[w, w + 1.0]]

# コンパイル
net_input = theano.function(inputs=[x],
								updates=update,
								outputs=z)

# 実行
data = np.array([[1, 2, 3]], dtype=theano.config.floatX)
for i in range(5):
	print('z%d:' % i, net_input(data))


# 初期化
data = np.array([[1, 2, 3]], dtype=theano.config.floatX)
x = T.fmatrix('x')
w = theano.shared(np.asarray([[0.0, 0.0, 0.0]], dtype=theano.config.floatX))
z = x.dot(w.T)
update = [[w, w + 1.0]]

# コンパイル
net_input = theano.function(inputs=[],
								updates=update,
								givens={x: data},
								outputs=z)

# 実行
for i in range(5):
	print('z%d:' % i, net_input())
