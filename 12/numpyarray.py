#! /usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
a = np.array([0, 1, 2, 3])
print(a)

b = np.array([[0, 0, 0], [0, 0, 0], [0, 0, 0]])
print(b)
print(b.ndim)
print(b.shape)
print(b.size)
print(b.dtype)

b2 = np.zeros(9).reshape(3, 3)
print(b2)
