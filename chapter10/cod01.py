import pandas as pd

df = pd.read_csv('datafile/bike.tsv', sep = '\t')
print(df.head(3))
