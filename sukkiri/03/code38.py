# elseブロックのない分岐
name = input('あなたの名前を教えて下さい >>')
print('{}さん、こんにちは'.format(name))
if name == '開発者':
    print('開発者さんに会えてうれしいです')

food = input('{}さんの好きな食べ物を教えて下さい >>'.format(name))

if 'カレー' in food:
    print('素敵です。とにかくカレーは最高ですよね!!')
else:
    print('私も{}が好きですよ'.format(food))
