scores = []
for i in range(10):
    score = int(input('{}人目の試験得点>> '.format(i + 1)))
    scores.append(score)

final_scores = []
for score in scores:
    tmp = score * 0.8 + 20
    final_scores.append(tmp)

avg = sum(final_scores) / len(final_scores)
print('平均点は{}点'.format(avg))
