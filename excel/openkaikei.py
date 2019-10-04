import openpyxl as px

wbk = px.load_workbook('kaikei.xlsx', data_only=True)
wsk = wbk['Sheet1']

for row in wsk.values:
    for value in row:
        print(value)
