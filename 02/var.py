#! /usr/bin/env python
# -*- coding: utf-8 -*-

# 赤道面での地球の円周を計算する
pi = 3.141592
diamter = 12756.274
print(pi * diamter)

# ジョギングで1キロ脂肪を燃やすのに何時間かかるかを計算する
cal_per_1kg = 7200
cal_per_1minjog = 7.76
min_to_lose1kg = cal_per_1kg / cal_per_1minjog

hours_to_lose1kg = min_to_lose1kg / 60
print(hours_to_lose1kg)
