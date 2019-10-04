import openpyxl as px

wbk = px.load_workbook('kaikei.xlsx', data_only=True)
wsk = wbk['Sheet1']

for row in wsk:
    rowstr = ""
    for cell in row:
        cellstr = "(%s, %s)" % (cell.coordinate, 'None' if cell.value is None else cell.value)
        rowstr += " %s " % cellstr
    print(rowstr)
