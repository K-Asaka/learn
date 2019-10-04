import openpyxl as px

wbr = px.load_workbook('report.xlsx', data_only=True)
wsr = wbr['Sheet1']
wsr.delete_cols(2)      # B列を削除

docstr = ""
for col in wsr.iter_cols(min_row=4, max_row=29, min_col=1, max_col=2):
    for cell in col:
        if cell.value != None:  # 空のセルではないか？
            if cell.value[0] == "　": docstr += "\n"    # 改行
            docstr += cell.value
print(docstr)
