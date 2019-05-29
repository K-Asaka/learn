#! /usr/bin/env python
# -*- coding: utf-8 -*-
import shelve
d = shelve.open("./11/shelvetest")
d.update({"one":1, "two":2})
print(list(d.items()))
d.close()
