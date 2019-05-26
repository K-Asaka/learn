#! /usr/bin/env python
# -*- coding: utf-8 -*-
print(type(1))
print(type("あいうえお"))
print(type(b"abcde"))
import sys
print(type(sys))

print(isinstance(1, type(1)))
print(isinstance(1, str))
print(isinstance("あいう", object))
