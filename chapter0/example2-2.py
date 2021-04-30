scores = []

scores.append(int(input("国語の点数を入力>> ")))
scores.append(int(input("数学の点数を入力>> ")))
scores.append(int(input("英語の点数を入力>> ")))

print(scores)

print('合計得点:{}点'.format(sum(scores)))
