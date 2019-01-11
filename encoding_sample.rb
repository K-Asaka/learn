# encoding: EUC-JP
# マジックコメント。スクリプトの最初の行に記述する。
# これはUTF-8を指定する例
# VimやEmacsの指定と共通化できるように以下の形式で指定することもできる。
# Emacsの場合
# -*- coding: utf-8 -*-
# Vimの場合
# vim:set fileencoding=utf-8:
# マジックコメントでUS-ASCIIが指定されている場合、日本語の文字を含んでいるとエラーになる。
# UTF=8は、文字列リテラルで「\u」を使うと、スクリプトエンコードにかかわらずUTF-8の文字列を作ることができる。
p __ENCODING__
s = "\u3042\u3044\u3046\u3048\u304a"
puts s
p s.encoding
