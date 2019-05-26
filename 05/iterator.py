#! /usr/bin/env python
# -*- coding: utf-8 -*-

f = open('./05/some.txt', encoding='utf-8')
lines = ''
for i in range(5):
    lines += f.readline()
print(lines)
