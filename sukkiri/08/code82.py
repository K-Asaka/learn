# SQLiteを使ったデータベース検索
import sqlite3

with sqlite3.connect('sample.db') as conn:
    cursor = conn.cursor()
    cursor.execute('SELECT ID, NAME FROM EMPLOYEES')
    for row in cursor.fetchall():
        print(row[0])
        print(row[1])
    