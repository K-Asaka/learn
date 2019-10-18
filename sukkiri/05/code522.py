# 指定された3食を表示するeat関数(デフォルト値を利用)
def eat(breakfast, lunch, dinner='カレー'):
    print('朝は{}を食べました。'.format(breakfast))
    print('昼は{}を食べました。'.format(lunch))
    print('晩は{}を食べました。'.format(dinner))
