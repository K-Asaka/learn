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


n = 10      # エージェント数(人数)
time = 5    # 取引回数

agents = [Agent(i, 1) for i in range(n)]

for i in range(time):
    giving_money(agents)

print([agent.wealth for agent in agents])
