def process(string):
    print('処理中:', string)

filename = 'somefile.txt'

with open(filename) as f:
    while True:
        char = f.read(1)
        if not char: break
        process(char)

