import openpyxl as px

good_wbk2 = px.load_workbook('good_kaikei.xlsx', data_only=True)
wsk_in = good_wbk2[good_wbk2.sheetnames[0]]

for row in wsk_in['B2:B6']:
    for cell in row:
        cell.number_format = '#,##0'

good_wbk2.save('good_kaikei2.xlsx')
