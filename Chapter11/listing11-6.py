

def process(string):
    print('処理中:', string)

filename = 'somefile.txt'

with open(filename) as f:
    char = f.read(1)
    while char:
        process(char)
        char = f.read(1)
