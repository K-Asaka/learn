def process(string):
    print('処理中:', string)

filename = 'somefile.txt'

with open(filename) as f:
    while True:
        line = f.readline()
        if not line: break
        process(line)

