# global文を用いてグローバル変数に代入する
name = '開発者'

def change_name():
    global name
    name = '分析者'

def hello():
    print('こんにちは' + name + 'さん')

change_name()
hello()
