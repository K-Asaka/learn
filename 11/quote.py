#! /usr/bin/env python
# -*- coding: utf-8 -*-

from urllib import parse
url = "https://www.google.com/webhp?ie=UTF-8#q="
url += parse.quote('python サンプルコード')
print(url)
