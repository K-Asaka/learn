#! /usr/bin/env python
# -*- coding: utf-8 -*-

# リストの値を合計する
the_list = [101, 123, 152, 123]
summary = 0
for item in the_list:
    summary = summary + item

print(summary)

# abs()関数の実行例
print(abs(10))
print(abs(-200))

# int()関数の実行例
print(int("100"))
print(int("100", 2))
print(int("100", 16))

# destiny_tank()関数の定義
def destiny_tank():
    tanks = ["IV号戦車D型", "III号戦車J型", "チャーチル Mk.VII",
             "M4シャーマン", "P40重戦車", "T-34/76"]
    num = input("好きな数字を入力して下さい:")
    idx = int(num) % len(tanks)
    print("あなたの運命の戦車は")
    print(tanks[idx])

destiny_tank()

# 引数を持つ関数の定義
def destiny_tank2(num):
    tanks = ["IV号戦車D型", "III号戦車J型", "チャーチル Mk.VII",
             "M4シャーマン", "P40重戦車", "T-34/76"]
    idx = num % len(tanks)
    print("あなたの運命の戦車は")
    print(tanks[idx])

num_str = input("好きな数字を入力してください:")
num = int(num_str)
destiny_tank2(num)

# ランダムな結果を返す
from random import randint
num = randint(0, 10)
destiny_tank2(num)

# 戻り値を持つ関数の定義
def destiny_tank3(num):
    tanks = ["IV号戦車D型", "III号戦車J型", "チャーチル Mk.VII",
             "M4シャーマン", "P40重戦車", "T-34/76"]
    idx = num % len(tanks)
    return tanks[idx]

from random import randint
num = randint(0, 10)
tank = destiny_tank3(num)
print("今日あなたが乗るべき幸運の戦車は", tank, "です")
