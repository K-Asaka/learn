#! /usr/bin/env python
# -*- coding: utf-8 -*-

class Prism:
    def __init__(self, width, height, depth, unit = 'cm'):
        self.width = width
        self.height = height
        self.depth = depth
        self.unit = unit
    def content(self):
        return self.width * self.height * self.depth
    def unit_content(self):
        return str(self.content()) + self.unit

p1 = Prism(10, 20, 30)
print(p1.content())
p2 = Prism(50, 60, 70)
print(p2.content())

print(p1.height)
print(p2.height)

p1.height = 50
print(p1.content())

p = Prism(10, 20, 30)
print(p.width)
p.depth = "30"
print(p.content())

class Cube(Prism):
    def __init__(self, length):
        super().__init__(length, length, length)


c = Cube(20)
print(c.content())

# 追加したアトリビュートの確認
c2 = Cube(10)
print(c2.unit_content())