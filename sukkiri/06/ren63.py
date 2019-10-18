# 練習問題6-3
def welcome(u):
    print('ようこそ{}さん'.format(u['name']))
    u['age'] = u['age'] + 1
    print('あなたは来年{}歳だから大吉です！'.format(u['age']))

username = input('名前を入力してください >>')
userage = int(input('年齢を入力してください >>'))
user = {'name':username, 'age':userage}
welcome(user)
print('{}際の{}さん、またプレイしてくださいね'.format(user['age'], user['name']))
