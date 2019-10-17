# BMI算出プログラム
# BMI = 体重(kg) ÷ 身長(m) ÷ 身長(m)
# アンパック代入とf-stringの応用構文を用いた例
h,w = int(input('身長(cm)は？ >>')) / 100, \
      float(input('体重(kg)は？ >>'))
print(f'BMIは{ w / h ** 2 }です')
