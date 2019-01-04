str1 = "これも文字列"
str2 = 'あれも文字列'

moji = "文字列"
str1 = "あれも#{moji}"
p str1
str2 = 'あれも#{moji}'
p str2

# %Q、%qを使う
desc = %Q{Rubyの文字列には「''」も「""」も使われます。}
str = %q|Ruby said, 'Hello world!'|

# ヒアドキュメントを使う
10.times do |i|
    print(<<"EOB")
i: #{i}
EOB
end
# 終了の記号のインデントを揃えたい場合
10.times do |i|
    print(<<-"EOB")
i: #{i}
    EOB
end
# 全体のインデントを揃えたい場合
10.times do |i|
    print(<<~"EOB")
        i: #{i}
    EOB
end
# ヒアドキュメントを変数に代入
str = <<-EOB
Hello!
Hello!
EOB

# 「``」を使う
# 「`コマンド`」の形式でコマンドの標準出力を受け取って文字列オブジェクトにできる
puts `cat /etc/hosts`

# sprintfメソッドを使う
# printf => コンソールへ出力
# sprintf => 文字列オブジェクトを返す
n = 65535
printf("%dの16進数表記は%xです\n", n, n)
p sprintf("%dの16進数表記は%xです\n", n, n)
# format => sprintfの別名
# 文字列 % 配列の形式でも同じことができる
p format("Hello, %s!", "Ruby")
p "%d年%d月%d日" % [2016, 2, 1]

# 指示子
p sprintf("%8s", "Ruby")
p sprintf("%8.8s", "Hello Ruby")
p sprintf("%#010x", 100)
p sprintf("%+.2f", Math::PI)
p sprintf("%*.*f", 5, 2, Math::PI)

# 文字列の長さを得る
p "just another ruby hacker,".length
p "just another ruby hacker,".size
p 'オブジェクト指向プログラミング言語'.length
p 'オブジェクト指向プログラミング言語'.bytesize
p "".empty?
p "foo".empty?

# 文字列のインデックス
str = "新しいStringクラス"
p str[0]
p str[3]
p str[9]
p str[2, 8]
p str[4]

# 文字列をつなげる
# 新しい文字列を作る
hello = "Hello, "
world = "World!"
str = hello + world
p str

# すでにある文字列に別の文字列をつなげる
hello = "Hello, "
world = "World!"
hello << world
p hello
hello.concat(world)
p hello
# hello = hello + worldとすると+でも<<メソッドを使ったのと同じ結果が得られる
# しかし中身は新しい文字列として生成されたオブジェクトなので他に変更前のhelloを
# 参照している変数があった場合、そちらには影響がない。

# 文字列を比較する
p "aaa" == "baa"
p "aaa" == "aa"
p "aaa" == "aaa"
p "aaa" != "baa"
p "aaa" != "aaa"

# 文字列の大小比較
p ("aaaaa" < "b")

# コードポイントを調べる
p "あ".ord

# 文字列を分割する
str = "高橋:タカハシ:1234567:000-123-4567"
column = str.split(/:/)
p column

# 改行文字の扱い
str = "abcde"           # 改行文字ではない場合
newstr = str.chop
p newstr
newstr = str.chomp
p newstr

str2 = "abcd\n"         # 改行文字の場合
newstr = str2.chop
p newstr
newstr = str2.chomp
p newstr

# 文字列の検索と置換
# 文字列の検索
str = "すもももももも"
p str.index("もも")
p str.rindex("もも")
p str.include?("もも")

# 文字列の置換
str = "abcde"
str[2, 1] = "C"
p str

p "abcde".slice(2, 3)
p "こんにちはRuby".byteslice(15, 4)

str = "Hello, Ruby."
p str.slice!(-1)
p str.slice!(5..6)
p str.slice!(0, 5)
p str

# each_lineメソッドで取り出した行をcollectメソッドで処理する
str = "あ\nい\nう\n"
tmp = str.each_line.collect do |line|
    line.chomp * 3
end
p tmp

# each_byteメソッドで取り出した数値をcollectメソッドで処理する
str = "abcde"
tmp = str.each_byte.collect do |byte|
    -byte
end
p tmp

# Enumeratorクラス
str = "AA\nBB\nCC\n"
p str.each_line.class
p str.each_line.map{|line| line.chop }
p str.each_byte.reject{|c| c == 0x0a }

# 文字列をつなぎ合わせる
s = "ようこそ"
s.concat("ゲストさん")
p s

# 該当する文字列strの部分を取り除く
s = "検/索/避/け"
p s.delete("/")

# 文字列sを逆順に並び替える
s = "こんばんわ"
p s.reverse

# その他のメソッド
# 文字列sの先頭と末尾にある空白文字をはぎとるメソッド
p " Thank you. ".strip

# 大文字・小文字を変換する
p "Object-Oriented Language".upcase
p "Object-Oriented Language".downcase
p "Object-Oriented Language".swapcase
p "Object-Oriented Language".capitalize

# 文字を置き換える
p "あいうえお".tr("い", "イ")
p "あいうえお".tr("いえ", "イエ")
p "あいうえお".tr("あ-お", "ア-オ")
