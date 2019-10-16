# 割り勘計算プログラムの修正(未完成)
price = input('料金を入力 >>')
price = int(price)
number = input('人数を入力 >>')
number = int(number)
payment = price / number
payment = int(payment)
print('お支払いは' + str(payment) + '円です')
