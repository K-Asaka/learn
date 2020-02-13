from PyPDF2 import PdfFileMerger
import os

mgr = PdfFileMerger()

filelist = os.listdir("pdffiles")
filelist = [f for f in filelist if '.pdf' in f]
print(filelist)

for filename in filelist:
    with open(os.path.join("pdffiles", filename), 'rb') as input:
        mgr.append(input)

output = open(os.path.join("pdffiles", "pdf_all.pdf"), "wb")
mgr.write(output)
output.close()
