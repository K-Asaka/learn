#! /usr/bin/env python
# -*- coding: utf-8 -*-

monk_fish_team = [158, 157, 163, 157, 145]
monk_fish_team.sort()
print(monk_fish_team)

monk_fish_team.sort(reverse=True)
print(monk_fish_team)

# タプルのリスト
tank_data = [("IV号戦車", 38, 80, 75), ("LT-38", 42, 50, 37),
             ("八九式中戦車", 20, 17, 57), ("III号突撃砲", 40, 50, 75),
             ("M3中戦車", 39, 51, 75)]

def evaluate_tankdata(tup):
    return tup[1] + tup[2] + tup[3]

print(evaluate_tankdata(tank_data[0]))
print(evaluate_tankdata(tank_data[4]))

tank_data.sort(key=evaluate_tankdata, reverse=True)
print(tank_data)
