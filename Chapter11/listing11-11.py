import fileinput

def process(string):
    print('処理中:', string)

filename = 'somefile.txt'

for line in fileinput.input(filename):
    process(line)

