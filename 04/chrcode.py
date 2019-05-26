#! /usr/bin/env python
# -*- coding: utf-8 -*-

s = "あいうえお"
print(len(s))

bs = s.encode("shift-jis")
print(len(bs))

print(bs)
print(s[0])
print(bs[0])

u = s.encode("euc-jp", "strict")
print(u)
u = bs.decode("shift-jis", "ignore")
print(u)

def guess_encoding(s):
    """
    バイト型の文字列を引数として受け取り、
    エンコードを簡易に判定する
    """
    # 判定を行うエンコードをリストに保存
    encodings = ["ascii", "utf-8", "shift-jis", "euc-jp"]
    for enc in encodings:
        try:
            s.decode(enc)       # エンコード変換を試みる
        except UnicodeDecodeError:
            continue            # エンコード変換に失敗したので次を試す
        else:
            return enc
            # エラーが発生しなかったら変換に成功したエンコードを返す
    else:
        return ""               # 成功したエンコードがなければ空文字列を返す

print(guess_encoding(s.encode('shift-jis', 'strict')))
