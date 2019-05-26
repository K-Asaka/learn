#! /usr/bin/env python
# -*- coding: utf-8 -*-

s = "abcde"
print(getattr(s, "find"))
print(s.find("cd"))
print(getattr(s, "find")("cd"))
