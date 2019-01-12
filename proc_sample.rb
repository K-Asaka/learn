hello1 = Proc.new do |name|
    puts "Hello, #{name}."
end

hello2 = proc do |name|
    puts "Hello, #{name}."
end

hello1.call("World")
hello2.call("Ruby")


# 西暦の年を与えられたときにうるう年かどうかを判定する処理
leap = Proc.new do |year|
    year % 4 == 0 && year % 100 != 0 || year % 400 == 0
end

p leap.call(2000)
p leap[2013]
p leap[2016]

double = Proc.new do |*args|
    args.map {|i| i * 2 }   # 要素をすべて2倍して返す
end

p double.call(1, 2, 3)
p double[2, 3, 4]


prc1 = Proc.new do |a, b, c|
    p [a, b, c]
end
prc1.call(1, 2)

prc2 = lambda do |a, b, c|
    p [a, b, c]
end
prc2.call(1, 2)
