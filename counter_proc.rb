def counter
    c = 0           # カウンターを初期化する
    Proc.new do     # callメソッドを呼ぶたびにカウンターに
        c += 1      # 1を足して返すProcオブジェクトを返す
    end
end

# カウンターc1を作成してカウントアップする
c1 = counter
p c1.call
p c1.call
p c1.call

# カウンターc2を作成してカウントアップする
c2 = counter
p c2.call
p c2.call

# 再びc1をカウントアップする
p c1.call
