def power(a, n):
    result = 1
    for i in range(n):
        result *= a
    return result

print(power(2, 10))
print(power(2, 5))
