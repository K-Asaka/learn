#! /usr/bin/env python
# -*- coding: utf-8 -*-

f = open('./05/some.txt', encoding='utf-8')
lines = ''
for i in range(5):
    lines += f.readline()
print(lines)

for c, l in enumerate(open('./05/some.txt', encoding='utf-8')):
    print(l, end=" ")
    if c == 4:
        break

i = iter([1, 2])
print(next(i))
print(next(i))
