#! /usr/bin/env python
# -*- coding: utf-8 -*-

for i in range(10, 21):
    print(i, end=' ')

seq = ["abcde", "fghij", "klm", "nopqrstu", "vwxyz"]
for cnt, item in enumerate(seq):
    print(cnt, item)

for n, w in zip([1, 2, 3, 4], ['a', 'b', 'c', 'd']):
    print(n, w)
