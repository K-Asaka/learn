class Class1:
    def method1(self):
        print(f'引数selfの値(method1): {self}')

def function1(self):
    print(f'引数selfの値(function1): {self}')

instance1 = Class1()
instance1.method1()
instance1.method1 = function1
instance1.method1()
