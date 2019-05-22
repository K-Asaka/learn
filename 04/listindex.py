#! /usr/bin/env python
# -*- coding: utf-8 -*-

def find_index(the_list, target):
    idx = 0
    for item in the_list:
        if target == item:
            return idx
        idx = idx + 1

mcz = ["れに", "かなこ", "しおり", "あやか", "ももか"]
print(find_index(mcz, "しおり"))

# 上記関数と同等のメソッド
print(mcz.index("しおり"))
