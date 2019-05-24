#! /usr/bin/env python
# -*- coding: utf-8 -*-

orig_str = "いっぱい"
print(orig_str.replace("い", "お"))

str_num = "1,000,000"
num = int(str_num.replace(",", ""))
print(num)

import matplotlib.pyplot as plt

str_speeds = "38 42 20 40 39"
str_armor = "80 50 17 50 51"
speeds = str_speeds.split(" ")
armors = str_armor.split(" ")
markers = ["o", "v", "^", "<", ">"]

for idx in range(len(speeds)):
    x = int(speeds[idx])
    y = int(armors[idx])
    plt.scatter(x, y, marker=markers[idx])

plt.show()

# IV号戦車(o) LT-38(v) 八九式中戦車(^) III号突撃砲(<) M3中戦車(>)

str_speeds = "38 42 20 40 39"
speeds = str_speeds.split()
csep_speeds = ",".join(speeds)
print(csep_speeds)

# replace()とjoin()の違い
str_speeds2 = " 38  42 20 40 39"
print(str_speeds2.replace(" ", ","))

speeds2 = str_speeds2.split()
csep_speeds2 = ",".join(speeds2)
print(csep_speeds2)

# エスケープシーケンス
def func():
    words = "ゆく河の流れは絶えずして\nしかももとの水にあらず"
    print(words)

func()

# raw文字列
raw = r"C:\path\to\file"
print(raw)

print("{} loves Python !".format('Guido'))

linkstr = '<a href="{}">{}</a>'
for i in [ 'http://python.org',
           'http://pypy.org',
           'http://cython.org', ]:
    print(linkstr.format(i, i.replace('http://', '')))

# 引数の順番を指定した置換
print("{0} {1} {0}".format('Spam', 'Ham'))

# キーワード引数を指定した置換
print("{food1} {food2} {food1}".format(food1='Spam', food2='Ham'))

# ディクショナリを指定した置換
d = {'name': 'Guido', 'birthyear': 1964}
print("{0[birthyear]} is {0[name]}'s birthyear.".format(d))

import sys
print("Python version: {0.version}".format(sys))

# 埋め込む文字列のフォーマット指定
tmp1 = "{0:10} {1:>8}"
print(tmp1.format('Spam', 300))
print(tmp1.format('Ham', 200))

print("{:.2%}".format(6381 / 12708))
print("{:,}".format(10000))

# f文字列
name = "君"
print(f"まずは{name}が落ち着け")
