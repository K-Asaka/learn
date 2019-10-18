# append関数やformat関数の呼び出し
tpl = '3人目は{}さん'
names = ['開発者', '分析者']
names.append('利用者')
message = tpl.format(names[2])
print(message)
