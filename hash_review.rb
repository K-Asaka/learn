# 配列
person = Array.new
person[0] = "田中一郎"
person[1] = "佐藤次郎"
person[2] = "木村三郎"
p person[1]

# ハッシュ
person = Hash.new
person["tanaka"] = "田中一郎"
person["satou"] = "佐藤次郎"
person["kimura"] = "木村三郎"
p person["satou"]

# ハッシュの作り方
# {}を使う
h1 = {"a"=>"b", "c"=>"d"}
p h1["a"]

h2 = {a: "b", c: "d"}
p h2

# Hash.newを使う
h1 = Hash.new
h2 = Hash.new("")
p h1["not_key"]
p h2["not_key"]

# 値を取り出す・設定する
# []を使う
h = Hash.new
h["R"] = "Ruby"
p h["R"]

# fetchメソッドを使う
h = Hash.new
h.store("R", "Ruby")
p h.fetch("R")
# キーがないと例外が発生する
#h = Hash.new
#p h.fetch("N")
# 第2引数をしていすれば、キーが登録されていない時に返す値として使用される
h = Hash.new
h.store("R", "Ruby")
p h.fetch("R", "(undef)")
p h.fetch("N", "(undef)")

# fetchメソッドは引数としてブロックを使うことができる
h = Hash.new
p h.fetch("N") { String.new }

# キーや値をまとめて取り出す
h = {"a"=>"b", "c"=>"d"}
p h.keys
p h.values
p h.to_a

# ハッシュのデフォルト値
# ハッシュの生成時にデフォルト値を指定する
# デフォルト値のデフォルトはnil
h = Hash.new(1)
h["a"] = 10
p h["a"]
p h["x"]
p h["y"]

# ハッシュのデフォルト値を生成するブロックを指定する
h = Hash.new do |hash, key|
    hash[key] = key.upcase
end
h["a"] = "b"
p h["a"]
p h["x"]
p h["y"]

# fetchメソッドで指定する
h = Hash.new do |hash, key|
    hash[key] = key.upcase
end
p h.fetch("x", "(undef)")

# あるオブジェクトをキーや値として持つか調べる
# ハッシュhがキーを持っている時にはtrue、持っていない時にはfalseを返す
h = {"a"=>"b", "c"=>"d"}
p h.key?("a")
p h.has_key?("a")
p h.include?("z")
p h.member?("z")

# あるオブジェクトを値として持っているかを調べる
p h.value?("b")
p h.has_value?("z")

# ハッシュの大きさを調べる
p h.length
p h.size

# 大きさが0(何もキーが登録されていない)かどうかを調べる
p h.empty?
h2 = Hash.new
p h2.empty?

# キーと値を削除する
# キーを指定して削除する
h = {"R"=>"Ruby"}
p h["R"]
h.delete("R")
p h["R"]

# deleteメソッドの引数にブロックを指定すると、キーが存在しなかった場合、ブロックの実行結果を返す
h = {"R"=>"Ruby"}
p h.delete("P"){|key| "no #{key}."}

# 条件を与えて、その条件に当てはまるものだけ削除する
h = {"R"=>"Ruby", "P"=>"Perl"}
p h.delete_if{|key, value| key == "P"}
# reject!メソッドを使う例
p h.delete_if{|key, value| key == "L"}
p h.reject!{|key, value| key == "L"}

# ハッシュを初期化する
# 一度使ったハッシュを空にする
h = {"a"=>"b", "c"=>"d"}
h.clear
p h.size

# h = Hash.newとし新しいハッシュを作っても同じだが、hを参照する他の変数がある場合に
# 新しいハッシュを作っているため影響を及ぼさない。
h = {"k1"=>"v1"}
g = h
h.clear
p g

h = {"k1"=>"v1"}
g = h
h = Hash.new
p g

# 2つのキーがあるハッシュを扱う
table = {"A"=>{"a"=>"x", "b"=>"y"},
         "B"=>{"a"=>"v", "b"=>"w"}}
p table["A"]["a"]
p table["B"]["a"]

# 2つのハッシュを合わせる
p ({"a"=>"x"}.merge({"b"=>"y"}))

# キーのクラスが違うため同一と見なされない
h = Hash.new
n1 = 1
n2 = 1.0
p n1 == n2
h[n1] = "exists."
p h[n1]
p h[n2]
