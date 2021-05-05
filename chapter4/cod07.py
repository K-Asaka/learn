import pandas as pd

data = [
    [160, 161],
    [160, 175]
]

df2 = pd.DataFrame(data, index = ['4月', '5月'], columns = ['松田の労働', '浅木の労働'])
print(df2)
