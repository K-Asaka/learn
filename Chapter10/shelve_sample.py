import shelve
s = shelve.open('test.dat')
s['x'] = ['a', 'b', 'c']
s['x'].append('d')
print(s['x'])

temp = s['x']
temp.append('d')
s['x'] = temp
print(s['x'])
