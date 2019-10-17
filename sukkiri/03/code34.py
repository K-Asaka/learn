# どんなカレーでも絶賛するチャットボット
name = input('あなたの名前を教えて下さい >>')
print('{}さん、こんにちは'.format(name))
food = input('{}さんの好きな食べ物を教えて下さい >>'.format(name))

if 'カレー' in food:
    print('素敵です。カレーは最高ですよね!!')
else:
    print('私も{}が好きですよ'.format(food))
