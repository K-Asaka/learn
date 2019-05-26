#! /usr/bin/evn python
# -*- coding: utf-8 -*-

orig_str = "よのなかねかおかおかねかなのよ"
str_list = list(orig_str)
str_list.reverse()
print("".join(str_list) == orig_str)

orig_str = "おかしがすきすきすがしかお"
print("".join(reversed(orig_str)) == orig_str)


tank_data = [("IV号戦車", 38, 80, 75), ("LT-38", 42, 50, 37),
             ("八九式中戦車", 20, 17, 57), ("III号突撃砲", 40, 50, 75),
             ("M3中戦車", 39, 51, 75)]

#def evaluate_tankdata(tup):
#   return tup[1] + tup[2] + tup[3]

tank_data.sort(key=lambda tup: sum(tup[1:4]), reverse=True)
print(tank_data)
# sorted()関数による置き換え
r = sorted(tank_data, key=lambda tup: sum(tup[1:4]), reverse=True)
print(r)
