# 関数の中からグローバル変数への代入を試みる
name = '開発者'

def change_name():
    name = '分析者'

def hello():
    print('こんにちは' + name + 'さん')

change_name()
hello()
