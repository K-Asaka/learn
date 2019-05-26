#! /usr/bin/env python
# -*- coding: utf-8 -*-

def execute(func, arg):
    return func(arg)

print(execute(int, "100"))

def logger(func):
    def inner(*args):
        print("引数：", args)
        return func(*args)
    return inner

def accumulate(a, b):
    return a + b

print(accumulate(1, 2))

newfunc = logger(accumulate)
print(newfunc(1, 2))
