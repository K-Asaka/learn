# Regexp.new(str)を使ってパターンを用意する
re = Regexp.new("Ruby")
# %rを使った方法もある。%r(),%r<>,%r||,%r!!など

# \zと\Zの違い
p "abc\n".gsub(/\z/, "!")
p "abc\n".gsub(/\Z/, "!")

# quoteメソッドを使った正規表現
# 問題点はメタ文字をメタ文字として書くことができない
re1 = Regexp.new("abc*def")
re2 = Regexp.new(Regexp.quote("abc*def"))
p (re1 =~ "abc*def")
p (re2 =~ "abc*def")

# 正規表現のオプション
# mオプションは「.」が改行文字にもマッチするようになる
str = "ABC\nDEF\nGHI"
p /DEF.GHI/ =~ str
p /DEF.GHI/m =~ str

# Regexp.newメソッドには第2引数にオプション定数を指定できる
Regexp.new("Rubyスクリプト", Regexp::IGNORECASE)
# 複数オプション定数を指定する場合
Regexp.new("Rubyスクリプト", Regexp::IGNORECASE | Regexp::MULTILINE)

# キャプチャ(後方参照)
# 正規表現でマッチした部分の一部を取り出すもの
/(.)(.)(.)/ =~ "abc"
first = $1
second = $2
third = $3
p first
p second
p third

# キャプチャする必要のないパターンをまとめる場合は、「(?: )」を使う
/(.)(\d\d)+(.)/ =~ "123456"
p $1
p $2
p $3
/(.)(?:\d\d)+(.)/ =~ "123456"
p $1
p $2

# マッチした部分より前の文字列、マッチした部分そのものの文字列、マッチした部分より後ろの文字列
/C./ =~ "ABCDEF"
p $`
p $&
p $'

# subメソッドとgsubメソッド
# 文字列中のある部分を、別の文字列に置き換えるためのメソッド
str = "abc   def  g    hi"
p str.sub(/\s+/, ' ')
p str.gsub(/\s+/, ' ')

# ブロックをとることもできる
str = "abracatabra"
nstr = str.sub(/.a/) do |matched|
    '<' + matched.upcase + '>'
end
p nstr

nstr = str.gsub(/.a/) do |matched|
    '<' + matched.upcase + '>'
end
p nstr

# scanメソッド
# パターンにマッチした部分を取り出す
"abracatabra".scan(/.a/) do |matched|
    p matched
end

# 正規表現の中で()が使われていると、そこにマッチした部分を配列にして返す
"abracatabra".scan(/(.)(a)/) do |matched|
    p matched
end

# ブロック変数を()の数だけ並べると、配列ではなくそれぞれの要素を取り出せる
"abracatabra".scan(/(.)(a)/) do |a, b|
    p a + "-" + b
end

# ブロックがない場合はマッチした文字列の配列を返す
p "abracatabra".scan(/.a/)

# URLを含む行を抽出する例
str = "http://www.ruby-lang.org/ja/"
%r|http://([^/]*)/| =~ str
print "server address: ", $1, "\n"

# RFC2396
%r|^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\?([^#]*))?(#(.*))?|
