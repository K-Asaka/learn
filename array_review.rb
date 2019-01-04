# 配列の作り方
nums = [1, 2, 3, 4, 5]
strs = ["a", "b", "c", "d"]
p nums
p strs

# Array.newを使う
a = Array.new
p a
a = Array.new(5)
p a
a = Array.new(5, 0)
p a

# %wや%iを使う
lang = %w(Ruby Perl Python Scheme Pike REBOL)
p lang

lang = %i(Ruby Perl Python Scheme Pike REBOL)
p lang

# to_aメソッドを使う
color_table = {black: "#000000", white: "#FFFFFF"}
p color_table.to_a

# 文字列のsplitメソッドを使う
column = "2016/02/01,foo.html,proxy.example.jp".split(',')
p column

# インデックスの使い方
p nums[1]
p nums[2..4]
p nums[1, 3]

# 要素を置き換える
nums[1] = 12
p nums
nums[1..3] = [12, 13, 14]
p nums
nums[1, 2] = [22, 23]
p nums

# 要素を挿入する
nums[2, 0] = [100, 200]
p nums

# 複数のインデックスから配列を作る
alpha = %w(a b c d e f)
p alpha.values_at(1, 3, 5)

# 集合としての配列
ary1 = ["a", "b", "c"]
ary2 = ["b", "c", "d"]
# 共通集合
p (ary1 & ary2)
# 和集合
p (ary1 | ary2)
# 集合の差
p (ary1 - ary2)
# 「|」と「+」の違い
num = [1, 2, 3]
even = [2, 4, 6]
p (num + even)
p (num | even)

# 「列」としての配列
# キュー
alpha = ["a", "b", "c", "d", "e"]
p alpha.push("f")
p alpha.shift
p alpha

# スタック
alpha = ["a", "b", "c", "d", "e"]
p alpha.push("f")
p alpha.pop
p alpha

# 参照のみ
a = [1, 2, 3, 4, 5]
p a.first
p a.last
p a

# 配列の主なメソッド
# 配列に要素を加える
a = [1, 2, 3, 4, 5]
a.unshift(0)
p a

a = [1, 2, 3, 4, 5]
a << 6
p a

a = [1, 2, 3, 4, 5]
a.concat([8, 9])
p a

a = [1, 2, 3, 4, 5, 6, 7, 8]
a[2..4] = 0
p a
a[1, 3] = 9
p a

# 破壊的なメソッド
a = [1, 2, 3, 4]
b = a
p b.pop
p b
p a

# 内容変更を禁止するfreezeメソッド
a = [1, 2, 3, 4]
a.freeze
b = a.dup
#p a.pop        # エラーになる
p b.pop

# 配列から要素を取り除く
# 要素がnilのものを取り除く
a = [1, nil, 3, nil, nil]
a.compact!
p a

# 要素xを取り除く
a = [1, 2, 3, 2, 1]
a.delete(2)
p a

# 配列a[n]の要素を取り除く
a = [1, 2, 3, 4, 5]
a.delete_at(2)
p a

# 配列aの各要素itemについて、ブロックを実行した結果が真だった場合、aからitemを取り除く
# reject, reject!も同様
a = [1, 2, 3, 4, 5]
a.delete_if{|i| i > 3}
p a

# 配列aから指定された部分を取り除き、取り除いた値を返す。
a = [1, 2, 3, 4, 5]
p a.slice!(1, 2)
p a

# 配列aの重複する要素を削除する
a = [1, 2, 3, 4, 3, 2, 1]
a.uniq!
p a

# 配列aの先頭要素を取り除き、取り除いた値を返す
a = [1, 2, 3, 4, 5]
a.shift
p a

# 配列aの末尾要素を取り除き、取り除いた値を返す
a = [1, 2, 3, 4, 5]
a.pop
p a

# 配列の要素を置き換える
# 配列aの各要素itemにブロックを適用し、その結果を集めて新しい配列を作る
# collect{|item| }, map{|item| }, map!{|item| }
a = [1, 2, 3, 4, 5]
a.collect! {|item| item * 2 }
p a

# 配列aの要素をvalueに置き換える
p [1, 2, 3, 4, 5].fill(0)
p [1, 2, 3, 4, 5].fill(0, 2)
p [1, 2, 3, 4, 5].fill(0, 2, 2)
p [1, 2, 3, 4, 5].fill(0, 2..3)

# 配列aを平坦化する
a = [1, [2, [3]], [4], 5]
a.flatten!
p a

# 配列aの要素を逆順に並べ替える
a = [1, 2, 3, 4, 5]
a.reverse!
p a

# 配列aの各要素を並べ替える。並べ替え方をブロックで指定できる
a = [2, 4, 3, 5, 1]
a.sort!
p a

# 配列aの要素を並べ替える。並べ替えはすべての要素についてブロックを評価した結果をソートした順に行われる
a = [2, 4, 3, 5, 1]
p a.sort_by{|i| -i }

# 配列とイテレータ
a = 1..5
b = a.collect{|i| i += 2}
p b

