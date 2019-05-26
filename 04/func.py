#! /usr/bin/env python
# -*- coding: utf-8 -*-

def foo(a, b, *vals):
    print(a, b, vals)

foo(1, 2, 3, 4, 5)

# 以下はエラーになる
#foo(1, 2, c=3)

def bar(a, b, **args):
    print(a, b, args)

bar(1, 2, c=3, d=4)
