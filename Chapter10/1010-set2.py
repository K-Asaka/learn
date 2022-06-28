from functools import reduce
my_sets = []
for i in range(10):
    my_sets.append(set(range(i, i+5)))

print(reduce(set.union, my_sets))

a = set()
b = set()
#a.add(b)
a.add(frozenset(b))
