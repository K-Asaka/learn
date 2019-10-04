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

new_wbk = px.Workbook()
wsk17_in = new_wbk.create_sheet("2017収入", 0)
wsk17_in.append(["項目", "金額"])
for row in wsk['A4:B8']:
    wsk17_in.append([row[i].value for i in range(len(row))])
wsk17_out = new_wbk.create_sheet("2017支出", 1)
wsk17_out.append(["項目", "金額"])
for row in wsk['D4:E11']:
    wsk17_out.append([row[i].value for i in range(len(row))])
new_wbk.save('new_kaikei.xlsx')

wsk17_in['B6'] = '=SUM(B2:B5)'
# ファイルを再生成
new_wbk.save('new_kaikei.xlsx')