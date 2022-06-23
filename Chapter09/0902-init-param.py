class FooBar:
    def __init__(self, value=42):
        self.somevar = value

f = FooBar('これはコンストラクタの引数です')
print(f.somevar)

g = FooBar()
print(g.somevar)
