#! /usr/bin/env python
# -*- coding: utf-8 -*-

# if文の例
if 2 * 2 * 2 + 2 == 10:
    print("2 * 2 * 2 + 2は10")
if 2 + 2 * 2 + 2 == 10:
    print("2 + 2 * 2 + 2は10")
if (2 + 2) * 2 + 2 == 10:
    print("(2 + 2) * 2 + 2は10")

# 数値を比較する条件式の例
if 1 == 1:
    print("1番目はTrue")
if 5 ^ (4 - 4) + 9 == 10:
    print("2番目はTrue")
if 2 < len([0, 1, 2]):
    print("3番目はTrue")
if sum([1, 2, 3, 4]) < 10:
    print("4番目はTrue")

# 文字列を比較する条件式の例
if "AUG" == "AUG":
    print("1番目はTrue")
if "AUG" == "aug":
    print("2番目はTrue")
if "あいう" == "あいう":
    print("3番目はTrue")

# in演算子の使用例
if "GAG" in "AUGACGGAGCUU":
    print("1番目はTrue")
if "恋と戦いはあらゆることが正当化されるのよ" in "正当化":
    print("2番目はTrue")
if "stumble" in "A hourse may stumble though he has four legs":
    print("3番目はTrue")

# リストを比較する条件式の例
if [1, 2, 3, 4] == [1, 2, 3, 4]:
    print("1番目はTrue")
if [1, 2, 3] == [2, 3]:
    print("2番目はTrue")
if [1, 2, 3] == ['1', '2', '3']:
    print("3番目はTrue")

# リスト内の要素を調べる条件式の例
if 2 in [2, 3, 5, 7, 11]:
    print("1番目はTrue")
if 21 in [13, 17, 19, 23, 29]:
    print("2番目はTrue")
if 'アッサム' in ['ダージリン', 'アッサム', 'オレンジペコ']:
    print("3番目はTrue")

# リスト内の要素を調べる条件式の例
if 1 in [0, 1, 2, 3, 4]:
    print("1番目はTrue")
if [1, 2] in [0, 1, 2, 3, 4]:
    print("2番目はTrue")
if [1, 2] in [0, 1, [1, 2], 3, 4]:
    print("3番目はTrue")

# else文の使用例
if 2 ^ 3 - 2 + 4 == 10:
    print("式1は10")
else:
    print("式1は10にならない")
if 2 ** 3 - 2 + 4 == 10:
    print("式2は10")
else:
    print("式2は10にならない")

# 2重のif文を使用した例
a_year = 2080
if a_year >= 1993:
    if a_year == 1993:
        print(a_year, "年、れに誕生")
    else:
        print(a_year, "年、れに", a_year-1993, "歳")

# elif文の使用例
a_year = 2080
if a_year == 1993:
    print(a_year, "年、れに誕生")
elif a_year > 1993:
    print(a_year, "年、れに", a_year-1993, "歳")

# for文とif文を組み合わせた例
a_num = 57
for num in range(2, a_num):
    if a_num % num == 0:
        print(a_num, "は素数ではありません")
        break

