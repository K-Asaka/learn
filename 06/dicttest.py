#! /usr/bin/env python
# -*- coding: utf-8 -*-
from strdict import StrDict
d = StrDict()
d["spam"] = 1
print(d["spam"])

# 数値のキーで要素を追加するとエラー
#d[1] = 1

print(d.keys())
