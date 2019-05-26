#! /usr/bin/env python
# -*- coding: utf-8 -*-

f = open("./04/foo.txt", "r", encoding="utf-8")
s = f.read()
print(s)
f.close()

f = open("./04/test.txt", 'r', encoding='utf-8')
for line in f:
    print(line, end=" ")

s = "ファイルにデータを書き込む"
f = open("./04/newfile.txt", "w", encoding="utf-8")
f.write(s)
f.close()

imgfile = open('./04/someimage.png', 'rb')
imgsrc = imgfile.read()
if imgsrc[1:4] == b'PNG':
    print('image/png')

import sys
print(sys.getfilesystemencoding())

