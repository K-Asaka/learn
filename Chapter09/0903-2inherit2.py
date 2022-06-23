class A:
    def hello(self):
        print("こんにちは、Aです。")

class B(A):
    def hello(self):
        print("こんにちは、Bです。")

a = A()
b = B()
a.hello()
b.hello()
