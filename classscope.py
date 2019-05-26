#! /usr/bin/env python
# -*- coding: utf-8 -*-
class Klass:
    a = 100

i1 = Klass()
i2 = Klass()
i1.a = 10
print(i1.a)
print(i2.a)
Klass.a = 1000
print(i2.a)
print(i1.a)
