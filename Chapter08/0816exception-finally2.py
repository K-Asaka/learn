x = 1
y = 3
try:
    x / y
except NameError:
    print("不明な変数")
else:
    print("うまくいった！")
finally:
    print("後始末中。")
