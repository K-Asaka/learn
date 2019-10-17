# 見通しの悪いプログラム
student_list = ['開発者', '分析者']
count = 0
for student in student_list:
    print('{}さんの試験結果を入力してください'.format(student))
    network = int(input('ネットワークの得点？ >>'))
    database = int(input('データベースの得点？ >>'))
    security = int(input('セキュリティの得点？ >>'))
    if student == '開発者':
        kai_scores = [network, database, security]
        kai_avg = sum(kai_scores) / len(kai_scores)
    else:
        bun_scores = [network, database, security]
        bun_avg = sum(bun_scores) / len(bun_scores)

print('開発者さんの平均点は{}です'.format(kai_avg))
print('分析者さんの平均点は{}です'.format(bun_avg))
