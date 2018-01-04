#! /usr/local/bin/ruby
# 関数的メソッドの定義
def odd?(n)
  # 値による多岐分岐
  case n % 2    # 剰余
  when 0 then false
  when 1 then true
  else raise "数学的にあり得ない"   # 例外送出
  end
end

while num = gets      # getsがnilを返すまで繰り返す
  # 正規表現による文字列のチェック
  unless /\A-?\d+\Z/ =~ num         # 「unless」は「if not」と同義
    $stderr.puts "整数を入力してください"
    next
  end
  num = num.to_i
  if odd?(num)
    puts "#{num}は奇数"
  else
    puts "#{num}は偶数"
  end
end

