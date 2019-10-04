import openpyxl as px
import sqlite3

conn = sqlite3.connect('people.db')
c = conn.cursor()

wbcp = px.Workbook()
wscp = wbcp.active
wscp.append(['ID', '名前', '出身', '生年', '略歴'])

for resultrow in c.execute('SELECT * FROM people'):
    wscp.append(resultrow)
wbcp.save('people_cp.xlsx')
conn.close()
