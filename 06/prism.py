#! /usr/bin/env python
# -*- coding: utf-8 -*-

class Prism:
    def __init__(self, width, height, depth):
        self.width = width
        self.height = height
        self.depth = depth
    
    def content(self):
        return self.width * self.height * self.depth

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

