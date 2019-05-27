#! /usr/bin/env python
# -*- coding: utf-8 -*-
import datetime
d1 = datetime.date(2016, 6, 28)
d2 = datetime.date(2015, 6, 28)
td = d1 - d2
print(td)

d1 = datetime.date(2016, 4, 14)
td = datetime.timedelta(days=100)
d2 = d1 + td
print(d2)

td = datetime.timedelta(days=5)
print(td * 2)
print(td / 3)

d1 = datetime.date(2016, 6, 28)
d2 = datetime.date(2016, 6, 28)
print(d1 > d2)
print(d1 == d2)
