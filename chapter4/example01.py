import pandas as pd

scores = {
    'データベースの試験得点': [70, 72, 75, 80],
    'ネットワークの試験得点': [80, 85, 79, 92]
}

df = pd.DataFrame(scores)

# 練習4-2
df.index = ['一郎', '次郎', '三郎', '太郎']

print(df)
