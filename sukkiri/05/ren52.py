# 練習問題5-2
def is_leapyear(y):
    return (y % 400 == 0 or (y % 4 == 0 and y % 100 != 0))

current_year = int(input('現在の西暦を入力してください >>'))
if is_leapyear(current_year):
    print('西暦{}年は、うるう年です'.format(current_year))
else:
    print('西暦{}年は、うるう年ではありません'.format(current_year))
