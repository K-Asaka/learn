f = open('somefile2.txt', 'w')
print(f.write('this\nis no\nhaiku\n'))
print(f.write('これは\n俳句では\nありません'))
f.close()
