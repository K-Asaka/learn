#! /usr/bin/env python
# -*- coding: utf-8 -*-

class Prop:
    def __init__(self):
        self.__x = 0
    def getx(self):
        return self.__x
    def setx(self, x):
        self.__x = x
    x = property(getx, setx)

i = Prop()
print(i.x)
i.x = 10
print(i.x)
print(i._Prop__x)
