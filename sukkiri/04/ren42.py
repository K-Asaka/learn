# 練習問題4-2
count = 1
ans = True
print('カレーを召し上がれ')
while ans == True:
    print('{}皿のカレーを食べました'.format(count))
    key = input('おかわりはいかがですか？ (y/n) >>')
    if key == 'y':
        count += 1
    else:
        ans = False
print('ごちそうさまでした')
