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

#def accumulate(a, b):
#    return a + b
#print(accumulate(1, 2))

#newfunc = logger(accumulate)
#print(newfunc(1, 2))

# デコレータ
@logger
def accumulate(a, b):
    return a + b

print(accumulate(1, 2))

from functools import lru_cache
@lru_cache(maxsize = None)
def fib(n):
    if n < 2:
        return n
    return fib(n - 1) + (n - 2)

print([fib(n) for n in range(16)])
