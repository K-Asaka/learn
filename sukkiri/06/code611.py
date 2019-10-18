# リストと文字列による書き換え時のidentity値の変化
names = list()
print('変更前のlistのidentity: {}'.format(id(names)))
names.append('開発者')
print('変更後のlistのidentity: {}'.format(id(names)))

name = '開発者'
print('変更前のstrのidentity: {}'.format(id(name)))
name = 'スーパー' + name
print('変更後のstrのidentity: {}'.format(id(name)))
