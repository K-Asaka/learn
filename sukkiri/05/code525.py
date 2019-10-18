# 夜がカレーじゃない日のeat関数の呼び出し
def eat(breakfast, lunch='ラーメン', dinner='カレー'):
    print('朝は{}を食べました。'.format(breakfast))
    print('昼は{}を食べました。'.format(lunch))
    print('晩は{}を食べました。'.format(dinner))

eat('納豆ごはん', 'ラーメン', 'カレーうどん')
# 昼のラーメンを省略したいが、省略すると昼がカレーうどんになってしまう
