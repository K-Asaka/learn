#! /usr/bin/env python
# -*- coding: utf-8 -*-
from urllib import request
from urllib import parse

postdic = {'name' : 'someone', 'email' : 'foo@bar.com'}

postdata = parse.urlencode(postdic)
print(postdata)

file = request.urlopen('http://service.com/process.cgi', postdata)
