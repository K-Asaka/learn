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

