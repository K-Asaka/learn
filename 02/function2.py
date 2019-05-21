#! /usr/bin/env python
# -*- coding: utf-8 -*-

monk_fish_team = [158, 157, 163, 157, 145]

total = sum(monk_fish_team)
length = len(monk_fish_team)
mean = total / length
variance = 0

for height in monk_fish_team:
    variance += (height - mean) ** 2

variance = variance / length

volleyball_team = [143, 167, 170, 165]

total2 = sum(volleyball_team)
length2 = len(volleyball_team)
mean2 = total2 / length2
variance2 = 0

for height in volleyball_team:
    variance2 += (height - mean) ** 2

variance2 = variance2 / length2
