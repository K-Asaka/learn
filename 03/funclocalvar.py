#! /usr/bin/env python
# -*- coding: utf-8 -*-

local_var = 1

def test_func(an_arg):
    local_var = an_arg
    print("test_func()の中 = ", local_var)

test_func(200)
print("test_func()の外 = ", local_var)
