numbers = [72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33]

from operator import add
from functools import reduce
print(reduce(add, numbers))

print(sum(numbers))
