import openpyxl as px
import sqlite3

DROP_PEOPLE = "DROP TABLE IF EXISTS people"
CREATE_PEOPLE = '''CREATE TABLE people
(id INTEGER PRIMARY KEY AUTOINCREMENT,
name TEXT,
land TEXT,
born INTEGER,
bio TEXT)'''

wbpp = px.load_workbook('people.xlsx', data_only=True)
wspp = wbpp[wbpp.sheetnames[0]]

for row in wspp.values:
    print(row)

wspp.delete_rows(1)

conn = sqlite3.connect('people.db')
c = conn.cursor()
c.execute(DROP_PEOPLE)
c.execute(CREATE_PEOPLE)
for row in wspp.values:
    sqlstr = "INSERT INTO people ('name', 'land', 'born', 'bio') VALUES(?, ?, ?, ?)"
    c.execute(sqlstr, row)
conn.commit()
