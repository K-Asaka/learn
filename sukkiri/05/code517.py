# 開発者と分析者の得点入力

def input_scores(name):
    print('{}さんの試験結果を入力してください'.format(name))
    network = int(input('ネットワークの得点？ >>'))
    database = int(input('データベースの得点？ >>'))
    security = int(input('セキュリティの得点？ >>'))
    scores = [network, database, security]
    return scores

def calc_average(scores):
    avg = sum(scores) / len(scores)
    return avg

def output_result(name, avg):
    print('{}さんの平均点は{}です'.format(name, avg))

kai_scores = input_scores('開発者')
bun_scores = input_scores('分析者')

kai_avg = calc_average(kai_scores)
bun_avg = calc_average(bun_scores)

output_result('開発者', kai_avg)
output_result('分析者', bun_avg)
