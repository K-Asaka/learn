from configparser import ConfigParser

CONFIGFILE = "Chapter19/listing19-1.cfg"
# CONFIGFILE = "area.ini"

config = ConfigParser()
# 設定・構成ファイルから読み込み
config.read(CONFIGFILE)

# 初期設定を出力
# 'messages' のセクションを見る
print(config['messages'].get('greeting'))

# radius(半径)を読み込むためのメッセージ(question)を読み込む
radius = float(input(config['messages'].get('question') + ' '))

# 結果を出力
# endをスペースに設定して改行しない
print(config['messages'].get('result_message'), end=' ')

# getfloat()を使って、値をfloat(浮動小数点数)に変換
print(config['numbers'].getfloat('pi') * radius**2)
