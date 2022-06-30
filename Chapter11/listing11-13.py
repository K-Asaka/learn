import fileinput

def process(string):
    print('処理中:', string)

filename = 'somefile.txt'

for line in open(filename):
    process(line)
