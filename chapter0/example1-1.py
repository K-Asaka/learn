height = int(input('身長を入力してください(cm): '))
weight = int(input('体重を入力してください(kg): '))

height = height / 100

bmi = weight / (height ** 2)

print('あなたのBMIは{}'.format(bmi))
