class Rectangle:
    def __init__(self):
        self.width = 0
        self.height = 0
    """
    __setattr__メソッドは、アクセスされた属性がsizeでなくても呼び出される。
    属性がsizeなら代入。それ以外の属性の場合は特殊属性の__dict__を使う。
    この属性にはインスタンスのすべての属性を含んだ辞書が入っている。
    __setattr__が再度呼び出されるのを避けるためこの属性を使う。
    通常の代入を行うと無限ループになる。
    """
    def __setattr__(self, name, value):
        if name == 'size':
            self.width, self.height = value
        else:
            self. __dict__[name] = value
    def __getattr__(self, name):
        if name == 'size':
            return self.width, self.height
        else:
            raise AttributeError()

r = Rectangle()
print(r.size)
r.size = 100, 150
print(r.width, r.height, r.size)
print(r.get_size())

