#-*- encoding: utf-8

import os
import struct
import numpy as np

def load_mnist(path, kind='train'):
	""" `path` から MNIST データをロード """
	# 引数に指定したパスを結合(ラベルや画像のパスを作成)
	labels_path = os.path.join(path, '%s-labels.idx1-ubyte' % kind)
	images_path = os.path.join(path, '%s-images.idx3-ubyte' % kind)

	# ファイルを読み込む：引数にファイル、モードを指定
	with open(labels_path, 'rb') as lbpath:
		# バイナリを文字列に変換。unpack関数の引数にフォーマット、8バイト分の
		# バイナリデータを指定してマジックナンバー、アイテムの個数を読み込む
		magic, n = struct.unpack('>II', lbpath.read(8))
		# ファイルからラベルを読み込み配列を構築：fromfile関数の引数に
		# ファイル、配列のデータ形式を指定
		labels = np.fromfile(lbpath, dtype=np.uint8)
	with open(images_path, 'rb') as imgpath:
		magic, num, rows, cols = struct.unpack(">IIII", imgpath.read(16))
		# 画像ピクセル情報の配列のサイズを変更
		# (行数：ラベルのサイズ、列数：特徴量の個数)
		images = np.fromfile(imgpath, dtype=np.uint8).reshape(len(labels), 784)

	return images, labels

X_train, y_train = load_mnist('../mnist', kind='train')
print('Rows: %d, columns: %d' % (X_train.shape[0], X_train.shape[1]))
X_test, y_test = load_mnist('../mnist', kind='t10k')
print('Rows: %d, columns: %d' % (X_test.shape[0], X_test.shape[1]))

# THEANO_FLAGS=mode=FAST_RUN,device=gpu,floatX=float32 python mnist_keras_mlp.py

import theano
theano.config.floatX = 'float32'
X_train = X_train.astype(theano.config.floatX)
X_test = X_test.astype(theano.config.floatX)

from keras.utils import np_utils
print('First 3 labels: ', y_train[:3])
y_train_ohe = np_utils.to_categorical(y_train)
print('\nFirst 3 labels (one-hot):\n', y_train_ohe[:3])

from keras.models import Sequential
from keras.layers.core import Dense
from keras.optimizers import SGD

np.random.seed(1)

model = Sequential()		# モデルを初期化
# 1つ目の隠れ層を追加
model.add(Dense(input_dim=X_train.shape[1],		# 入力ユニット数
				output_dim=50,					# 出力ユニット数
				init='unifom',					# 重みを一様乱数で初期化
				activation='tanh'))				# 活性化関数(双曲線正接関数)
# 2つ目の隠れ層を追加
model.add(Dense(input_dim=50,
				output_dim=50,
				init='uniform',
				activation='tanh'))
# 出力層を追加
model.add(Dense(input_dim=50,
				output_dim=y_train_ohe.shape[1],
				init='uniform',
				activation='softmax'))
# モデルコンパイル時のオプティマイザを設定
# 引数に学習率、荷重減衰定数、モーメンタム学習を設定
sgd = SGD(lr=0.001, decay=1e-7, momentum=.9)
# モデルをコンパイル
model.compile(loss='categorical_crossentropy',		# コスト関数
			  optimizer='sgd'						# オプティマイザ
			  metrics=['accuracy'])					# モデルの評価指標

model.fit(X_train,					# トレーニングデータ
		  y_train_ohe,				# 出力データ
		  nb_epoch=50,				# エポック数
		  batch_size=300,			# バッチサイズ
		  verbose=1,				# 実行時にメッセージを出力
		  validation_split=0.1)		# 検証用データの割合

y_train_pred = model.predict_classes(X_train, verbose=0)
print('First 3 predictions: ', y_train_pred[:3])

train_acc = np.sum(y_train == y_train_pred, axis=0) / X_train.shape[0]
print('Training accuracy: %.2f%%' % (train_acc * 100))

y_test_pred = model.predict_classes(X_test, verbose=0)
test_acc = np.sum(y_test == y_test_pred, axis=0) / X_test.shape[0]
print('Test accuracy: %.2f%%' % (test_acc * 100))
