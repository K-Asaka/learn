import openpyxl as px

wbw = px.load_workbook('weather.xlsx', data_only=True)
print(wbw.sheetnames)
wsw = wbw['Sheet1']
for row in wsw.values:
    for value in row:
        print(value)

print("Cellオブジェクトを使って表示")
for rowobj in wsw:
    for cellobj in rowobj:
        print(cellobj.value)
