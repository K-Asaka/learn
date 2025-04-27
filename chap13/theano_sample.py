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
