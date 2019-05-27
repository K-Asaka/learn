#! /usr/bin/env python
# -*- coding: utf-8 -*-
import sys

for fn in sys.argv[1:]:
    # try:
    #     f = open(fn)
    # except FileNotFoundError:
    #     print("{}というファイルは存在しません".format(fn))
    # else:
    #     try:
    #         print(fn, len(f.read()))
    #     finally:
    #         f.close()
    with open(fn) as f:
        for line in f:
            print(line)
