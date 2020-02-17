with open('txtfiles/sample2.txt', 'a', encoding='utf-8') as f:
    f.write('書き込みもできます')

with open('txtfiles/sample2.txt', encoding='utf-8') as f:
    print(f.read())
