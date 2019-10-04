import openpyxl as px

wbk = px.load_workbook('kaikei.xlsx', data_only=True)
wsk = wbk['Sheet1']

for row in wsk:
    rowstr = ""
    for cell in row:
        cellstr = "(%s, %s)" % (cell.coordinate, 'None' if cell.value is None else cell.value)
        rowstr += " %s " % cellstr
    print(rowstr)

in17 = wsk['A4:B8']
for row in in17:
    print(row[0].value, row[1].value)

