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

lifechart = np.loadtxt('./12/lifechart2014.csv', delimiter=",", usecols=[3])
rev_lifechart = np.ones(lifechart.size) - lifechart
rep_level = np.array([0.0041, 0.107, 0.19, 0.0697, 0.017, 0.0021, 0.0001])
high_rate = np.array([0.0036, 0.0514, 0.1593, 0.0927, 0.0187, 0.0023, 0.0001])

# 男女の人口データを推定するarrayを定義
fp_male = np.array(p_male[-2:])
fp_female = np.array(p_female[-2:])

# 人口置き換え水準に戻る期間(割る5)
recover_in = 5

for i in range(20):
    # 5年ごと100年間分繰り返す
    # 直近の5歳階級別で新しい人口を初期化
    new_fp_male = fp_male[-1]
    new_fp_female = fp_female[-1]
    # 出生率を設定
    if i > recover_in:
        f_rate = rep_level
    else:
        f_rate = high_rate
    # 15-49際の女性人口に出生率をかけて新生児数を計算
    newborn = np.sum(new_fp_female[3:10] * f_rate) * 5
    # 直近の5最階級別人口のインデックス
    # を右にずらし、新生児を左に連結
    new_fp_male = np.hstack(([newborn * 0.4878], new_fp_male[:-1]))
    new_fp_female = np.hstack(([newborn * 0.5122], new_fp_female[:-1]))
    # 各階級別の人口に死亡率を適用
    new_fp_male *= rev_lifechart
    new_fp_female *= rev_lifechart
    # 新しい推定人口を追加
    fp_male = np.vstack((fp_male, new_fp_male))
    fp_female = np.vstack((fp_female, new_fp_female))

# 男女合算の5歳階級別人口、5年ごとの推定総人口のarrayを作る
fp_total = fp_male + fp_female
fp_sum = np.array([np.sum(x) for x in fp_total])

t = plt.plot(range(2013, 2120, 5), fp_sum)
t = plt.ylim([0, 130000])
plt.grid(True)
plt.show()

# ウィジェット
#t = interact(show_pgraph, year=IntSlider(min=2013, max=2113, step=5),
#             arr1=fixed(fp_male), arr2=fixed(fp_female), arr3=fixed(fp_sum),
#             ymin=fixed(2013), ymax=fixed(2120), ydim=fixed(5))
