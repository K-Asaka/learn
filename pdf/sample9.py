from PyPDF2 import PdfFileReader
from PyPDF2 import PdfFileWriter
import os

filelist = os.listdir("pdffiles")
filelist = [f for f in filelist if '.pdf' in f]

for filename in filelist:
    pdf_file = os.path.join("pdffiles", filename)
    fp = open(pdf_file, 'rb')
    input = PdfFileReader(fp)
    output = PdfFileWriter()
    output.appendPagesFromReader(input)
    output.encrypt("abcdefg")
    outputfile = open(pdf_file[:-4] + "withpasswd.pdf", 'wb')
    output.write(outputfile)
    outputfile.close()
    fp.close()
