with open('txtfiles/sample1.txt', 'a') as f:
    f.write('書き込みもできます')

with open('txtfiles/sample1.txt') as f:
    print(f.read())
