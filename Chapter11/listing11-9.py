def process(string):
    print('処理中:', string)

filename = 'somefile.txt'

with open(filename) as f:
    for char in f.read():
        process(char)
