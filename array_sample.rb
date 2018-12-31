# 配列を作る
names = ["小林", "林", "高野", "森岡"]

# 配列の空オブジェクト
array = []

# 配列からオブジェクトを取り出す
print "最初の名前は", names[0], "です。\n"

# 配列に新しいオブジェクトを格納する
names[0] = "野尻"
print names, "\n"

# オブジェクトの格納先として、オブジェクトのまだ存在しない位置を指定
names[4] = "小林"
print names, "\n"

# 配列の中身
num = [3, 1, 4, 1, 5, 9, 2, 6, 5]
mixed = [1, "歌", 2, "風", 3]

# 配列と大きさ
print "namesの要素数: ", names.size, "\n"
print "arrayの要素数: ", array.size, "\n"

# 配列と繰り返し
names.each do |n|
    puts n
end
