#! /usr/bin/env python
# -*- coding: utf-8 -*-

def fizzbuzz(count = 100, fizzmod = 3, buzzmod = 5):
    for cnt in range(1, count + 1):
        if cnt % fizzmod == 0 and cnt % buzzmod == 0:
            print("FizzBuzz")
        elif cnt % fizzmod == 0:
            print("Fizz")
        elif cnt % buzzmod == 0:
            print("Buzz")
        else:
            print(cnt)

fizzbuzz()
