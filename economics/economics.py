import random

n = 10      # エージェント数(人数)
time = 5    # 取引回数

# 資産の初期値を設定
money = [1 for i in range(n)]

for i in range(time):
    # ランダムで2人選ぶ
    agent1 = random.choice(range(n))
    agent2 = random.choice(range(n))

    if money[agent1] >= 1:
        money[agent2] += 1  # agent2の資産を1増やす
        money[agent1] -= 1  # agent1の資産を1減らす

print(money)    # 結果の確認
