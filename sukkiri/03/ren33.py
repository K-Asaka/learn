# 練習問題3-3
isError = False
n = 99
if isError == False and n < 100:
    print('正解です')

number = int(input('数値を入力してください >>'))
if number % 2 == 0:
    print('偶数です')
else:
    print('奇数です')

greeting = input('挨拶をどうぞ >>')
if greeting == 'こんにちは':
    print('ようこそ')
elif greeting == '景気は？':
    print('ぼちぼちです')
elif greeting == 'さようなら':
    print('お元気で！')
else:
    print('どうしました？')

