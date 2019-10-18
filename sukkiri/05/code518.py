# 2つの戻り値を返す？
def plus_and_minus(a, b):
    return a + b, a - b

next, prev = plus_and_minus(1978, 1)

print('next={}, prev={}'.format(next, prev))
