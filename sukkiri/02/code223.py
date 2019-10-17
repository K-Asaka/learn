# コレクションの相互変換
scores = {'network':60, 'database':80, 'security':60}
members = ['開発者', '分析者', '利用者']
print(tuple(members))
print(list(scores))
print(set(scores.values()))
