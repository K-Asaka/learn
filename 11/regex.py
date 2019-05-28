#! /usr/bin/env python
# -*- coding: utf-8 -*-
import re
from urllib import request

url = "https://www.python.org/"
src = request.urlopen(url).read()
src = src.decode("utf-8")

pat = re.compile(r'href="(/static/.+?)"')

for match in pat.finditer(src):
    print(match.group(1))
