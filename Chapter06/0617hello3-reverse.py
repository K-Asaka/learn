def hello_3(name='皆さん', greeting='こんにちは'):
    print(f'{name}、{greeting}！')

params = {'name': '次郎さん', 'greeting': 'お久しぶりです'}
hello_3(**params)
