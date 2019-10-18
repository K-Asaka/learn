# 練習問題5-5
# 計算データの入力
amount = int(input('支払総額を入力してください >>'))
people = int(input('参加人数を入力してください >>'))

# 割り勘の計算
dnum = amount / people  # 総額を人数で割る(端数も保持)
pay = dnum // 100 * 100 # 100円未満を切り捨てる
if dnum > pay:          # 元の値と比較して、
    pay = int(pay + 100)    # 小さければ100円未満があったので上乗せ

# 幹事の支払額の計算
payorg = amount - pay * (people - 1)

# 結果の表示
print('*** 支払額 ***')
print('1人あたり{}円({}人)、幹事は{}円です'.format(pay, people - 1, payorg))
