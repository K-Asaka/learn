import csv

with open('txtfiles/sample3.csv', encoding='utf-8') as f:
    reader = csv.reader(f)
    csvlist = list(reader)
    print(csvlist)
