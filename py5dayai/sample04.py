import numpy as np

arr_1 = np.array([1, 2, 3])
arr_2 = np.array([2, 3, 4])
print(np.dot(arr_1, arr_2))
print('')

arr_1 = np.array([[1, 2], [3, 4]])
arr_2 = np.array([[5, 6], [7, 8]])
print('[[1, 2], [3, 4]]と[[5, 6], [7, 8]]の行列の積')
print(np.dot(arr_1, arr_2))
