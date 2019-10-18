# 開発者の言うまでもない食生活を出力する

def eat(breakfast, lunch, dinner='カレー'):
    print('朝は{}を食べました。'.format(breakfast))
    print('昼は{}を食べました。'.format(lunch))
    print('晩は{}を食べました。'.format(dinner))

print('8月1日')
eat('トースト', 'おにぎり')
print('8月2日')
eat('納豆ごはん', 'ラーメン')
print('8月3日')
eat('バナナ', 'そば', '焼肉')
print('8月4日')
eat('サンドウィッチ', 'しゅうまい弁当')
