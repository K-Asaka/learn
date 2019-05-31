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

from matplotlib import gridspec
def show_pgraph(year, arr1, arr2, arr3, ymin, ymax, ydim=1):
    # 人口ピラミッドを表示する
    # 表示する人口のインデックスを得る
    idx = int((year - ymin) / ydim)
    # 人口ピラミッドと人口グラフのグリッドを生成
    gs = gridspec.GridSpec(2, 2, height_ratios=(3, 2))
    # グラフの配置を決める
    ax = [plt.subplot(gs[0, 0]), plt.subplot(gs[0, 1]), plt.subplot(gs[1, :])]
    # 男性の人口ピラミッドを描く
    ax[0].barh(range(0, 101, 5), arr1[idx], height=3)
    ax[0].set(ylim=(0, 100), xlim=(0, 6000))
    ax[0].invert_xaxis()
    ax[0].yaxis.tick_right()
    # 女性の人口ピラミッドを描く
    ax[1].barh(range(0, 101, 5), arr2[idx], height=3)
    ax[1].tick_params(labelleft=False)
    ax[1].set(ylim=(0, 100), xlim=(0, 6000))
    # 人口グラフを描き西暦に線を引く
    ax[2].plot(range(ymin, ymax + 1, ydim), arr3, ls=":")
    ax[2].plot([year, year], [0, 140000])
    plt.show()

# Jupyter Notebookのウィジェット機能
# from ipywidgets import interact, IntSlider, fixed
# t = interact(show_pgraph, year=IntSlider(min=1944, max=2014, step=5),
#              arr1=fixed(p_male), arr2=fixed(p_female), arr3=fixed(p_yearly),
#              ymin=fixed(1944), ymax=fixed(2014), ydim=fixed(1))

show_pgraph(1950, p_male, p_female, p_yearly, 1944, 2014)

