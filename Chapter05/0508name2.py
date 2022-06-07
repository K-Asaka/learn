name = ''
while not name:
    name = input('名前を入力してください: ')
print(f'こんにちは、{name}さん')

# 半角の空白文字にも対応するには
# while not name or name.isspace()
# とする
