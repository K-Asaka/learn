#! /usr/bin/env python
# -*- coding: utf-8 -*-

def calc_variance(a_list):
    total = sum(a_list)
    length = len(a_list)
    mean = total / length
    variance = 0

    for height in a_list:
        variance += (height - mean) ** 2
    variance = variance / len(a_list)

    return variance


monk_fish_team = [158, 157, 163, 157, 145]
volleyball_team = [143, 167, 170, 165]
pravda_team = [127, 172, 140, 160, 174]

monk_team_variance = calc_variance(monk_fish_team)
volley_team_variance = calc_variance(volleyball_team)
pravda_team_variance = calc_variance(pravda_team)

print(monk_team_variance ** 0.5)
print(volley_team_variance ** 0.5)
print(pravda_team_variance ** 0.5)
