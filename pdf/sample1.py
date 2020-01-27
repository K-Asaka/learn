from pdfminer.pdfinterp import PDFResourceManager
from pdfminer.converter import TextConverter
from pdfminer.pdfinterp import PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.layout import LAParams
from io import StringIO

fp = open("pdf/sample1.pdf", 'rb')
outfp = StringIO()

rmgr = PDFResourceManager()
lprms = LAParams()
device = TextConverter(rmgr, outfp, laparams=lprms)

iprtr = PDFPageInterpreter(rmgr, device)

# パスワード付きPDFの場合はget_pages()にpassword引数でパスワードを指定する
for page in PDFPage.get_pages(fp):
    iprtr.process_page(page)

text = outfp.getvalue()

outfp.close()
device.close()
fp.close()

print(text)
