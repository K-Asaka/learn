# 関数名が重複すると…
from math import log

def log(msg):
    print('{}を記録します'.format(msg))

log(10) # 対数を求めるつもりが、ログが出力される
