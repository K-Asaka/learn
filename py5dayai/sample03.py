import numpy as np

arr = np.array([1, 2, 3])
arr = arr * 3
print('[1, 2, 3] * 3:{}'.format(arr))

arr = np.array([[1, 2, 3], [2, 3, 4]])
print('')
print('転置前')
print(arr)
print('')
print('転置後')
print(arr.T)
