#! /usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt

p_male = np.loadtxt('./12/male_1944_2014.csv', delimiter=",", skiprows=1, usecols=range(1, 22))
p_female = np.loadtxt('./12/female_1944_2014.csv', delimiter=",", skiprows=1, usecols=range(1, 22))

p_total = p_male + p_female
p_yearly = p_total.sum(axis=1)

t = plt.plot(range(1944, 2015), p_yearly)
plt.ylim((0, 130000))
plt.grid(True)
plt.show()

tfr = np.loadtxt('./12/total_fertility_rate.csv', delimiter=",", skiprows=1)
t = plt.plot(range(1960, 2015), tfr, ls=":")
t = plt.plot([1960, 2015], [2.07, 2.07])
plt.show()
