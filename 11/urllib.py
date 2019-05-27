#! /usr/bin/env python
# -*- coding: utf-8 -*-
from urllib import request
src = request.urlopen('https://www.python.org/').read()
print(src)
