# 練習問題7-5
file_r = open('sample.txt', 'r')
file_w = open('copy.txt', 'w')
for line in file_r:
    file_w.write(line)
file_r.close()
file_w.close()
