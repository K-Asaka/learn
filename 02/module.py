#! /usr/bin/env python
# -*- coding: utf-8 -*-

import random

print(random.random())
print(random.randint(0, 6))
a_list = [0, 1, 2, 3, 4, 5]
random.shuffle(a_list)
print(a_list)
print(random.choice(a_list))
