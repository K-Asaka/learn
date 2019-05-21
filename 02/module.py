#! /usr/bin/env python
# -*- coding: utf-8 -*-

import random

print(random.random())
print(random.randint(0, 6))
a_list = [0, 1, 2, 3, 4, 5]
random.shuffle(a_list)
print(a_list)
print(random.choice(a_list))

# asを使ったimport文の記述
# import モジュール名 as 読み込む名前(別名)
# fromを使ったインポート
# from モジュール名 import 関数名など
# importのあとに*を使うと、モジュールの持つ関数などをまとめてインポートできる
# しかし、副作用が大きいためあまり使わないほうが良い
from statistics import median

monk_fish_team = [158, 157, 163, 157, 145]
volleyball_team = [143, 167, 170, 165]
# 数値リストから中央値を計算する
print(median(monk_fish_team))
print(median(volleyball_team))

# モジュールの探し方
# http://docs.python.jp/3/
