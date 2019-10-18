# さまざまな機能を担当する関数の定義
def input_scores(name):
    print('{}さんの試験結果を入力してください'.format(name))
    network = int(input('ネットワークの得点？ >>'))
    database = int(input('データベースの得点？ >>'))
    security = int(input('セキュリティの得点？ >>'))
    scores = [network, database, security]

def calc_average(scores):
    avg = sum(scores) / len(scores)
    print('平均点は{}です'.format(avg))

def output_result(name, avg):
    print('{}さんの平均点は{}です'.format(name, avg))
