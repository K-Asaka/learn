# 不要な回のループをスキップする
ages = [28, 50, 'ひみつ', 20, 78, 25, 22, 10, '無回答', 33]
samples = list()
for data in ages:
    if not isinstance(data, int):
        continue
    if data < 20 or data >= 30:
        continue
    samples.append(data)
print(samples)
