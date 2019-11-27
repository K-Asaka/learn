from matplotlib import pyplot as plt
import random

class Agent:
    def __init__(self, unique_id, initial_wealth):
        self.unique_id = unique_id      # id番号
        self.wealth = initial_wealth    # 初期資産

def giving_money(agents):
    agent1 = random.choice(agents)
    agent2 = random.choice(agents)

    if agent1.wealth >= 1:
        agent2.wealth += 1
        agent1.wealth -= 1

# ジニ係数を計算する関数
def gini(y):
    y.sort()
    n = len(y)
    nume = 0

    for i in range(n):
        nume = nume + (i + 1) * y[i]
        deno = n * sum(y)
    
    return ((2 * nume)/deno - (n + 1)/(n)) * (n / (n - 1))

def making_value(agents):
    agent1 = random.choice(agents)
    agent2 = random.choice(agents)

    a = random.random()     # 0から1の乱数を生成

    if agent1.wealth >= 1:
        agent2.wealth = agent2.wealth + 1 + a
        agent1.wealth = agent1.wealth - 1 + a


n = 300      # エージェント数(人数)
time = 1000    # 取引回数

agents = [Agent(i, 1) for i in range(n)]

for i in range(time):
    making_value(agents)

agent_wealth = [a.wealth for a in agents]
G = gini(agent_wealth)
print("G = " + str(G))
plt.hist(agent_wealth, bins=50)
plt.show()
