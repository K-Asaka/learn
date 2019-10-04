import openpyxl as px
from openpyxl.drawing.image import Image
from openpyxl.styles import Alignment

books = [{'title':'プリンピキア', 'author':'ニュートン', 'cover':'apple.png'},
         {'title':'化学原論', 'author':'ラボアジェ', 'cover':'chem.png'},
         {'title':'Goettliche und menschliche Gerechtigkeit', 'author':'Zwingli', 'cover':''},
         {'title':'熱の解析的理論', 'author':'フーリエ', 'cover':'wave.png'},
         {'title':'Astroscopia Compendiaria', 'author':'Huygens', 'cover':''}]

wbbk = px.Workbook()
wsbk = wbbk.active
wsbk.append(['タイトル', '著者', 'ブックカバー'])

# img = Image('apple.png')
# wsbk.add_image(img, 'C1')
for book in books:
    rownum = books.index(book) + 2
    bookdata = [v for k, v in book.items()]
    wsbk.append(bookdata[:2])
    if len(bookdata[2]) > 0:
        img = Image(bookdata[2])
        wsbk.add_image(img, 'C' + str(rownum))
        wsbk.row_dimensions[rownum].height = 135
        wsbk.column_dimensions['A'].width = 30
        wsbk.column_dimensions['B'].width = 20
    for row in wsbk.iter_rows(min_row=2, max_col=2):
        for cell in row:
            cell.alignment = Alignment(vertical='center', wrap_text=True)

wbbk.save('books.xlsx')
