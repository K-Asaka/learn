#! /usr/bin/env python
# -*- coding: utf-8 -*-
import pickle
o = [1,2,3,{"one":1}, {"two": 2}]
pickle.dump(o, open("./11/pickle.dump", "wb"))

o2 = pickle.load(open("./11/pickle.dump", "rb"))
print(o2)
