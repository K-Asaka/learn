def hello_3(name='皆さん', greeting='こんにちは'):
    print(f'{name}、{greeting}！')
def hello_4(name, greeting='こんにちは', punctuation='！'):
    print(f'{greeting}、{name}{punctuation}')

hello_3()
hello_3('皆様')
hello_3('ご通行中の皆様', 'こんばんは')

hello_4('太郎さん')
hello_4('太郎さん', 'おはよう')
hello_4('太郎さん', 'おはようございます', '...')
hello_4('太郎さん', punctuation='。')
hello_4('太郎さん', greeting='こんばんは')
hello_4()
