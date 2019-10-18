# 特定の変数や関数だけを別名を付けて利用する
from math import pi as ensyuritsu
from math import floor as kirisute
print('円周率は{}です'.format(ensyuritsu))
print('小数点以下を切り捨てれば{}です'.format(kirisute(ensyuritsu)))