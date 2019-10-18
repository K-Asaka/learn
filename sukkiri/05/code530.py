# おやつも食べた日のeat関数の呼び出し(可変長引数を利用)

def eat(breakfast, lunch, dinner='カレー', *desserts):
    print('朝は{}を食べました。'.format(breakfast))
    print('昼は{}を食べました。'.format(lunch))
    print('晩は{}を食べました。'.format(dinner))
    for d in desserts:
        print('おやつに{}を食べました'.format(d))

eat('トースト', 'パスタ', 'カレー', 'アイス', 'チョコ', 'パフェ')
