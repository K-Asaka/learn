# encoding: utf-8
p "こんにちは".encoding

str = "こんにちは"
p str.encoding
str2 = str.encode("EUC-JP")
p str2.encoding
# 異なるエンコーディングの文字列を連結しようとするとエラーが出る
#str3 = str1 + str2

# 比較
p "あ" == "あ".encode("Shift_JIS")

p Encoding.compatible?("AB".encode("EUC-JP"), "あ".encode("UTF-8"))
p Encoding.compatible?("あ".encode("EUC-JP"), "あ".encode("UTF-8"))

p Encoding.find("Shift_JIS")
p Encoding.find("shift_jis")

p Encoding.list
p Encoding.name_list

p Encoding.find("shift_jis").name

enc = Encoding.find("ASCII-8BIT")
p enc.names

str = [127, 0, 0, 1].pack("C4")
p str
p str.encoding

require 'open-uri'
str = open("http://www.ruby-lang.org/ja/").read
p str.encoding

# ASCII-8BITの文字列であっても、本来の文字コードがわかる場合
str.force_encoding("Windows-31J")
p str.encoding

# 適切なエンコーディングか調べる
str = "こんにちは"
str.force_encoding("US-ASCII")
str.valid_encoding?
#str + "みなさん"

# 通常、正規表現リテラルのエンコーディングはスクリプトエンコーディングと同じになる
# encoding: EUC-JP
a = "\u3042\u3044"
p /あ/ =~ a

str = "パターン".encode("EUC-JP")
re = Regexp.new(str)
p re.encoding

p Encoding.default_external
p Encoding.default_internal
File.open("foo.txt") do |f|
    p f.external_encoding
    p f.internal_encoding
end

$stdin.set_encoding("Shift_JIS:UTF-8")
p $stdin.external_encoding
p $stdin.internal_encoding

# 外部エンコーディングとしてUTF-8を指定する
File.open("foo.txt", "w:UTF-8")

# 外部エンコードとしてShift_JISを指定し、内部エンコーディングとしてUTF-8を指定する
File.open("foo.txt", "r:Shift_JIS:UTF-8")
