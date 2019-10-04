import openpyxl as px

wbk = px.load_workbook('kaikei.xlsx', data_only=True)
wsk = wbk['Sheet1']

for row in wsk.values:
    cellstr = ""
    for value in row:
        if value is None:
            value = "None"
        cellstr += " %s " % value
    print(cellstr)
