from PyPDF2 import PdfFileReader

fp = open("pdffiles/sample2.pdf", 'rb')
reader = PdfFileReader(fp)

pgnum = reader.getNumPages()

for i in range(pgnum):
    pg = reader.getPage(i)

    if '/XObject' in pg['/Resources']:
        xobjs = pg['/Resources']['/XObject']
        for key, obj in xobjs.items():
            item = obj.getObject()
            if item['/Subtype'] == '/Image':
                if '/Filter' in item and item['/Filter'] == '/DCTDecode':
                    img = open(key[1:] + ".jpg", 'wb')
                    data = item.getData()
                    img.write(data)
                    img.close()

fp.close()
