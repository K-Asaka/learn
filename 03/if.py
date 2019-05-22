#! /usr/bin/env python
# -*- coding: utf-8 -*-

v = 30000
if v < 28400:
    print("地上に落下します")
if v >= 28400 and v < 40300:
    print("月とお友達です")
if v >= 40300 and v < 60100:
    print("惑星の仲間入りです")
if v >= 60100:
    print("アルファケンタウリを目指せ")
