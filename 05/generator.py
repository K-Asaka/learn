#! /usr/bin/env python
# -*- coding: utf-8 -*-

def get_primes(x = 2):
    while True:
        for i in range(2, x):
            if x % i == 0:
                break
        else:
            yield x
        x += 1

i = get_primes()
for c in range (10):
    print(next(i))

# ジェネレータ式の例
i = (x ** 2 for x in range(1, 10))
print(next(i))
print(next(i))
print(next(i))
