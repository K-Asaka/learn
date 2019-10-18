# 文字列を引き渡しても悪影響が起きない
def add_suffix(name):
    name= name + 'さん'
    return name

before_name = '開発者'
after_name = add_suffix(before_name)
print('さん付け後:' + after_name)
print('さん付け前:' + before_name)
