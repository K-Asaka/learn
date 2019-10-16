# BMI算出プログラム
# BMI = 体重(kg) ÷ 身長(m) ÷ 身長(m)
h = int(input('身長(cm)は？ >>')) / 100
w = float(input('体重(kg)は？ >>'))
bmi = w / h / h
print('BMIは{}です'.format(bmi))
