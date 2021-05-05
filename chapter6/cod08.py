import pandas as pd

test = pd.DataFrame(
    {'Acolumn': [1, 2, 3],
     'Bcolumn': [4, 5, 6]
    }
)

print(test[test['Acolumn'] < 2])
print(test['Acolumn'] < 2)
