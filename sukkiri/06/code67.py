# リストオブジェクトのコピーによる不可解な動作
scores1 = [80, 40, 50]
scores2 = [80, 40, 50]
print('scores1の先頭要素は{}'.format(scores1[0]))
print('scores2の先頭要素は{}'.format(scores2[0]))

print('変数scores2の中身をscores1に代入(コピー)します')
scores1 = scores2

print('scores1の先頭要素を90に書き換えます')
scores1[0] = 90

print('90を代入したscores1の先頭要素は{}'.format(scores1[0]))
print('90を代入していないscores2の先頭要素は{}'.format(scores2[0]))
