def func(x):
    return x.isalnum()

seq = ["foo", "x41", "?!", "***"]
print(list(filter(func, seq)))

# 内包記法で書けば関数を定義する必要はない
print([x for x in seq if x.isalnum()])
