def factorial(n):
    result = n
    for i in range(1, n):
        result *= i
    return result

print(factorial(2))
print(factorial(8))
