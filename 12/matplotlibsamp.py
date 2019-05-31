#! /usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt

s = np.sin(np.pi * np.arange(0.0, 2.0, 0.01))
t = plt.plot(s)
plt.show()

x = np.random.randn(5000)
y = np.random.randn(5000)
t = plt.plot(x, y, 'o', alpha = 0.1)
plt.show()

x = np.array([1.628, 3.363, 5.145, 7.683, 9.855])
y = np.array([1.257, 3.672, 5.841, 7.951, 9.775])

a = np.array([x, np.ones(x.size)])
a = a.T
m, c = np.linalg.lstsq(a, y)[0]
t = plt.plot(x, y, 'o')
t = plt.plot(x, (m * x + c))
plt.show()

s = np.sin(np.pi * np.arange(0.0, 2.0, 0.01))
t = plt.plot(s, linestyle='--', linewidth=4)
plt.show()

# 表示用フォントの指定
plt.rcParams['font.family'] = 'Osaka'

import matplotlib.font_manager as fm
print(fm.findSystemFonts())
