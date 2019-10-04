import openpyxl as px
from openpyxl.drawing.image import Image

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
   bookdata = [v for k, v in book.items()]
   wsbk.append(bookdata[:2])
   if len(bookdata[2]) > 0:
       img = Image(bookdata[2])
       wsbk.add_image(img, 'C' + str(books.index(book) + 2))

wbbk.save('books.xlsx')
