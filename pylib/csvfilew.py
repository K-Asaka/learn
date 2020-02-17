import csv

with open('txtfiles/sample3.csv', 'a', encoding='utf-8', newline='') as f:
    writer = csv.writer(f)
    writer.writerow(['2019/12/8', '大野一成', 43])
    writer.writerow(['2019/12/9', '小栗知之', 49])
