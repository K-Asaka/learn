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