#! /usr/bin/env python
# -*- coding: utf-8 -*-

#import bookmark
#b = bookmark.Bookmark("タイトル", "http://path.to/site")

from bookmark import Bookmark
b = Bookmark("タイトル", "http://path.to/site")

# 他のモジュールからインポートしたクラスを使って継承
#import bookmark
#class Blogmark(bookmark.Bookmark):
#    pass

from bookmark import Bookmark
class Blogmark(Bookmark):
    pass

