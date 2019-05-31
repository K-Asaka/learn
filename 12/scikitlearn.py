#! /usr/bin/env /python
# -*- coding: utf-8 -*-
import numpy as np

# 乱数のシードを設定
np.random.seed(9)
# 0から1まで100個の数値を生成、乱数要素を混ぜる前のx
x_orig = np.linspace(0, 1, 100)

def f(x):
    # xに対応するsinを返す関数
    return np.sin(2 * np.pi * x)

# 0から1まで100個のばらけたサンプルデータ(x)を生成
x = np.random.uniform(0, 1, size=100)[:, np.newaxis]
# xに対応するsinに乱数値を足してサンプルデータ(y)を生成
y = f(x) + np.random.normal(scale=0.3, size=100)[:, np.newaxis]

import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split

# 学習用データとテスト用データに分ける
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.8)

# 元のsinとサンプルデータをplot
plt.plot(x_orig, f(x_orig), ls=':')
plt.scatter(x_train, y_train)
plt.xlim((0, 1))
plt.show()
