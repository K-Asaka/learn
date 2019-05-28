#! /usr/bin/env python
# -*- coding: utf-8 -*-
from urllib import request
from urllib import parse
import os

url = 'ftp://ftp.jp.freebsd.org/pub/FreeBSD/README.TXT'
filename = parse.urlparse(url)[2].split('/')[-1]

print(filename)

filename = os.path.join('./11/', filename)

request.urlretrieve(url, filename)
