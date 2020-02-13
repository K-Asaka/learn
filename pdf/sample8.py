from PyPDF2 import PdfFileReader
from PyPDF2 import PdfFileWriter

fp = open("pdffiles/sample2.pdf", 'rb')
input = PdfFileReader(fp)

pgnum = input.getNumPages()

for i in range(pgnum):
    output = PdfFileWriter()
    output.addPage(input.getPage(i))
    outputfile = open("pdffiles/pdf_" + str(i) + ".pdf", 'wb')
    output.write(outputfile)
    outputfile.close()

fp.close()
