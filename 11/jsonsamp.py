#! /usr/bin/env python
# -*- coding: utf-8 -*-
from urllib.request import urlopen
from json import loads

url = 'https://api.github.com/users/gvanrossum/repos'
body = urlopen(url).read()
body = body.decode('utf-8')
repos = loads(body)
for r in repos:
    print(r['name'])
