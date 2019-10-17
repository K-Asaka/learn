# ディクショナリの中にディクショナリをネスト
kai_scores = {'network':60, 'database':80, 'security':50}
bun_scores = {'network':80, 'database':75, 'security':92}
member_scores = {
    '開発者': kai_scores,
    '分析者': bun_scores
}
print(kai_scores)
print(bun_scores)
print(member_scores)
