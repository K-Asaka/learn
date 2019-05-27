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
