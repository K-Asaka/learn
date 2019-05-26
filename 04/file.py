#! /usr/bin/env python
# -*- coding: utf-8 -*-

f = open("./04/foo.txt", "r", encoding="utf-8")
s = f.read()
print(s)
f.close()

f = open("./04/test.txt", 'r', encoding='utf-8')
for line in f:
    print(line, end=" ")
