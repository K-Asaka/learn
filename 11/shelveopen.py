#! /usr/bin/env python
# -*- coding: utf-8 -*-
import shelve
d2 = shelve.open("./11/shelvetest")
print(list(d2.items()))
