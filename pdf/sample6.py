from PyPDF2 import PdfFileMerger

input1 = open("pdffiles/sample1.pdf", 'rb')
input2 = open("pdffiles/sample2.pdf", 'rb')

mgr = PdfFileMerger()
mgr.append(input1)
mgr.append(input2)

output = open("pdffiles/pdf12.pdf", 'wb')
mgr.write(output)
output.close()

input1.close()
input2.close()
