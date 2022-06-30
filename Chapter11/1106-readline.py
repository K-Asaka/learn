f = open('somefile.txt')
for i in range(4):
    print(str(i) + ': ' + f.readline(), end='')
print()
f.close()
