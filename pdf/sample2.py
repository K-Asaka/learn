from pdfminer.pdfdocument import PDFDocument
from pdfminer.pdfdocument import PDFNoOutlines
from pdfminer.pdfparser import PDFParser

fp = open('pdf/sample1.pdf', 'rb')
prsr = PDFParser(fp)
doc = PDFDocument(prsr)

try:
    outlines = doc.get_outlines()
    for outline in outlines:
        level = outline[0]
        title = outline[1]
        print("  " * (level - 1), title)
except PDFNoOutlines:
    print("しおりはありません。")

fp.close()
