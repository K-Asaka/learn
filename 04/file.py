#! /usr/bin/env python
# -*- coding: utf-8 -*-

f = open("./04/foo.txt", "r", encoding="utf-8")
s = f.read()
print(s)
f.close()
