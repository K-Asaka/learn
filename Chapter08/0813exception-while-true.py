while True:
    try:
        x = int(input('最初の数を入れてください: '))
        y = int(input('2番目の数を入れてください: '))
        value = x / y
        print(f'{x}/{y}は{value}です。')
    except:
        print('入力が正しくありません。再入力してください')
    else:
        break
