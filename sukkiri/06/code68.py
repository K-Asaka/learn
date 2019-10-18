# 関数に渡すと変数の内容を書き換えられてしまう
def add_suffix(names):
    for i in range(len(names)):
        names[i] = names[i] + 'さん'
    return names

before_names = ['開発者', '分析者', '利用者']
after_names = add_suffix(before_names)
print('さん付け後:' + after_names[0])
print('さん付け前:' + before_names[0])
