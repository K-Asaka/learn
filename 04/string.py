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
