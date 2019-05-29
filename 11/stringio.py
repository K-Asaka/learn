#! /usr/bin/env python
# -*- coding: utf-8 -*-
from io import StringIO
f = StringIO()
f.write("a" * 10)
f.seek(0)
print(f.read())
