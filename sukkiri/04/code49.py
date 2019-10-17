# データのまとまりからサンプルを抽出する
ages = [28, 50, 8, 20, 78, 25, 22, 10, 27, 33]
num = 5
samples = list()
for age in ages:
    if 20 <= age < 30:
        if len(samples) < num:
            samples.append(age)
print(samples)
