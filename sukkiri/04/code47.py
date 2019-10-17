# for文でリストの全要素を参照する
scores = [80, 20, 75, 60]
for data in scores:
    if data >= 60:
        print('合格')
    else:
        print('不合格')
