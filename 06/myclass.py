#! /usr/bin/env python
# -*- coding: utf-8 -*-

class MyClass:
    pass

i = MyClass()
i.value = 5
print(i.value)

i2 = MyClass()
i2.value = 12
print(i2.value)

class MyClass2():
    def __init__(self):
        self.value = 0
        print("This is __init__() method !")

i3 = MyClass2()
print(i3.value)
