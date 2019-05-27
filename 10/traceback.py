#! /usr/bin/env python
# -*- coding: utf-8 -*-
from urllib import request
request.urlopen("spam://spam.spam/")

# tracebackモジュールを使うと例外が発生したときに出力されるトレースバックを
# 表示したり、文字列に格納したりできる。
# import traceback
# try:
#     pass
# except:
#     traceback.print_exc()       # 例外を表示
#     ex = traceback.print_exc()  # 例外を文字列として取り出す
