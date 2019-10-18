# 例外処理
try:
    price = int(input('料金を入力 >>'))
    number = int(input('人数を入力 >>'))
    print('1人あたり{}円です'.format(price / number))
except ValueError:
    print('料金または人数は整数を入力してください')
except ZeroDivisionError:
    print('人数に0は入力しないでください')
except:
    print('すべての実行エラーに対応する')
print('プログラムを終了します')
