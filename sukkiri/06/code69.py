# 防御的コピーを用いて悪影響を防ぐ
def add_suffix(names):
    for i in range(len(names)):
        names[i] = names[i] + 'さん'
    return names

before_names = ['開発者', '分析者', '利用者']
copied_names = list()
for n in before_names:
    copied_names.append(n)
after_names = add_suffix(copied_names)
print('さん付け後:' + after_names[0])
print('さん付け前:' + before_names[0])
