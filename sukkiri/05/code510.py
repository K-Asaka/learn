# 複数の引数を渡しながらprofile関数を呼び出す

def profile(name, age, hobby):
    print('私の名前は{}です。'.format(name))
    print('年齢は{}歳です。'.format(age))
    print('趣味は{}です。'.format(hobby))

profile('開発者', 24, '開発')
profile('分析者', 30, '分析')
