#! /usr/bin/env python
# -*- coding: utf-8 -*-

cnt = 1
while cnt <= 100:
    if cnt % 3 == 0 and cnt % 5 == 0:
        print("FizzBuzz")
    elif cnt % 3 == 0:
        print("Fizz")
    elif cnt % 5 == 0:
        print("Buzz")
    else:
        print(cnt)
    cnt = cnt + 1
