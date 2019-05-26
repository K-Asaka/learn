#! /usr/bin/env python
# -*- coding: utf-8 -*-

f = open('./05/some.txt', encoding='utf-8')
body = f.read()
lines = body.split('\n')
print('\n'.join(lines[:5]))
