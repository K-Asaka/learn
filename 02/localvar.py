#! /usr/bin/env python
# -*- coding: utf-8 -*-

def test_func(arg1):
    inner_var = 100
    print(arg1 + inner_var)

test_func(10)
# 関数内で定義した変数を表示しようとするとエラーになる
#print(inner_var)
