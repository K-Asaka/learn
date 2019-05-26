#! /usr/bin/env python
# -*- coding: utf-8 -*-
class Klass:
    __slots__ = ['a', 'b']
    def __init__(self):
        self.a = 1

i = Klass()
print(i.a)

i.b = 2
print(i.b)

# 制限されているため以下はエラー
#i.c = 3
