def total2(from, to, &block)
    result = 0                  # 合計の値
    from.upto(to) do |num|      # fromからtoまで処理する
        if block                # ブロックがあれば
            result += block.call(num)       # ブロックで処理した値を足す
        else                    # ブロックがなければ
            result += num       # そのまま足す
        end
    end
    return result               # メソッドの結果を返す
end

p total2(1, 10)                 # 1から10の和
p total2(1, 10){|num| num ** 2} # 1から10の2乗の値の和
