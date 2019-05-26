#! /usr/bin/env python
# -*- coding: utf-8 -*-
class Aklass:
    def __init__(self):
        self.spam = 1

i = Aklass()
print(dir(i))

i.egg = 1
print(dir(i))
