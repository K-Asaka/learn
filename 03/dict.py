#! /usr/bin/env python
# -*- coding: utf-8 -*-

purple = {"ニックネーム": "れにちゃん",
          "出身地": "神奈川県",
          "キャッチフレーズ": "感電少女"}

print(purple["出身地"])
print(purple)

purple["キャッチフレーズ"] = "鋼少女"
print(purple)

purple["生年月日"] = "1993年6月21日"
print(purple)

del purple["ニックネーム"]
print(purple)

def convert_number(num):
    # アラビア数字とローマ数字の対応表をディクショナリに定義
    roman_nums = {1:"Ⅰ", 2:"Ⅱ", 3:"Ⅲ", 4:"Ⅳ", 5:"Ⅴ",
                  6:"Ⅵ", 7:"Ⅶ", 8:"Ⅷ", 9:"Ⅸ"}
    # ディクショナリのキーとして引数の整数が存在していたら
    # キーに対応する値を戻り値にする
    if num in roman_nums:
        return roman_nums[num]
    else:
        return "[変換できません]"

print(convert_number(3))
print(convert_number(15))

purple = {"ニックネーム": "れにちゃん",
          "出身地": "神奈川県",
          "キャッチフレーズ": "感電少女",
          "生年月日": "1993年6月21日"}

for key in purple:
    print(key, purple[key])
