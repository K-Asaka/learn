#! /usr/bin/env python
# -*- coding: utf-8 -*-
from urllib import request
src = request.urlopen('https://www.python.org/').read()
print(src)

from collections import OrderedDict
od = OrderedDict()
od['a'] = 'A'
od['c'] = 'C'
od['b'] = 'B'
print(od)

d = {}
d['a'] = 'A'
d['c'] = 'C'
d['b'] = 'B'
print(d)

animals = [('猫', '三毛'), ('犬', 'コーギー'),
           ('猫', 'シャム'), ('犬', 'ダックス'),
           ('犬', '黒ラブ')]
d = {}
for k, v in animals:
    if k not in d:
        d[k] = [v]
    else:
        d[k].append(v)
print(d)

d = {}
for k, v in animals:
    d.setdefault(k, []).append(v)
print(d)
