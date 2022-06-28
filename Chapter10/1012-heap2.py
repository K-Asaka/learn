from heapq import *
heap = [5, 8, 0, 3, 6, 7, 9, 1, 4, 2]
heapify(heap)
print(heap)

print(heapreplace(heap, 0.5))
print(heap)
print(heapreplace(heap, 10))
print(heap)
