# input_scores関数とcalc_average関数
def input_scores(name):
    print('{}さんの試験結果を入力してください'.format(name))
    network = int(input('ネットワークの得点？ >>'))
    database = int(input('データベースの得点？ >>'))
    security = int(input('セキュリティの得点？ >>'))
    scores = [network, database, security]

def calc_average(scores):
    avg = sum(scores) / len(scores)
    print('平均点は{}です'.format(avg))
