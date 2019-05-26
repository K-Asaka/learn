#! /usr/bin/env python
# -*- coding: utf-8 -*-
class Atomklass:
    def foo(self):
        print("this is foo method!")

i1 = Atomklass()
i2 = Atomklass()
i1.bar = i1.foo
# コピーしたメソッドを呼び出す
i1.bar()
# このインスタンスではエラーになる
#i2.bar()
