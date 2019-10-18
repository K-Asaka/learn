# 戻り値のタプルをアンパック代入
def plus_and_minus(a, b):
    return (a + b, a - b)

(next, prev) = plus_and_minus(1978, 1)

print('next={}, prev={}'.format(next, prev))
