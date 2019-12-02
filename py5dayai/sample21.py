from sklearn.datasets import load_iris

iris_dataset = load_iris()
print(iris_dataset.keys())
print(iris_dataset['data'])
print(iris_dataset['target'])
print(iris_dataset['target_names'])
