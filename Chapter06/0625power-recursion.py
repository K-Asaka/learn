def power(a, n):
    if n == 0:
        return 1
    else:
        return a * power(a, n - 1)

print(power(2, 10))
print(power(2, 5))
