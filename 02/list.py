#! /usr/bin/env python
# -*- coding: utf-8 -*-

# 変数にリストを代入する
tokyo_temps = [15.1, 15.4, 15.2, 15.4, 17.0, 16.9]

# グラフ表示の準備
import matplotlib.pyplot as plt
# グラフの表示
plt.plot(tokyo_temps)
plt.show()

# インデックスを指定して要素を取り出す
print(tokyo_temps[0])

# リスト要素の引き算
print(tokyo_temps[5] - tokyo_temps[0])

# リストの最後の要素を指定する
print(tokyo_temps[-1] - tokyo_temps[0])

# リストの足し算
e_tokyo_temps = [13.6, 13.5, 14.2, 14.8, 14.8]
tokyo_temps2 = e_tokyo_temps + tokyo_temps
# グラフの表示
plt.plot(tokyo_temps2)
plt.show()

# リスト「mcz」の作成
mcz = ["れに", "あかり", "かなこ", "しおり", "あやか", "ゆきな"]
print(mcz)
# 5番目の要素を書き換える
mcz[5] = 'ももか'
print(mcz)

# 要素の削除
del mcz[0]
print(mcz)

# スライスの使用例
momotamai = mcz[1:3]
print(momotamai)
print(mcz[:2])
print(mcz[1:])
