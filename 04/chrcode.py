#! /usr/bin/env python
# -*- coding: utf-8 -*-

s = "あいうえお"
print(len(s))

bs = s.encode("shift-jis")
print(len(bs))

print(bs)
print(s[0])
print(bs[0])
