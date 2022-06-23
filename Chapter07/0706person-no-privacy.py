class Person:
    def set_name(self, name):
        self.name = name
    def get_name(self):
        return self.name
    def greet(self):
        print("こんにちは。私は{}です。".format(self.name))

foo = Person()
bar = Person()
foo.set_name('ルーク・スカイウォーカー')
bar.set_name('アナキン・スカイウォーカー')

print(foo.name)
foo.name = 'ガンビー'
print(foo.get_name())
