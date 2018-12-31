sym = :foo      # これがシンボル「:foo」を表す
sym2 = :"foo"   # 上と同じ意味

print sym.to_s, "\n"        # シンボルを文字列に変換
print "foo".to_sym, "\n"    # 文字列をシンボルに変換

# ハッシュを作る
song = { :title => "Paranoid Android", :artist => "Radiohead" }
person = { "名前" => "高橋", "仮名" => "タカハシ" }
mark = { 11 => "Jack", 12 => "Queen", 13 => "King" }

# 次の2つは同じ意味
person1 = { :name => "後藤", :kana => "ゴトウ" }
person2 = { name: "後藤", kana: "ゴトウ" }

address = { name: "高橋", furigana: "タカハシ", postal: "1234567" }

puts song
puts person
puts mark
puts person1
puts person2

# ハッシュの操作
print address[:name], "\n"

# ハッシュの繰り返し
address.each do |key, value|
    puts "#{key}: #{value}"
end
