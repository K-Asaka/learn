# 目標数に達したら繰り返しを終了する
ages = [28, 50, 8, 20, 78, 25, 22, 10, 27, 33]
num = 5
samples = list()
for age in ages:
    if 20 <= age < 30:
        samples.append(age)
        if len(samples) == num:
            break
print(samples)
