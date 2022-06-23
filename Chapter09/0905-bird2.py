class Bird:
    def __init__(self):
        self.hungry = True
    def eat(self):
        if self.hungry:
            print('いただきます！')
            self.hungry = False
        else:
            print('お腹いっぱい！')

class SongBird(Bird):
    def __init__(self):
        super().__init__()
        self.sound = 'ホー、ホケキョ！'
    def sing(self):
        print(self.sound)

b = Bird()
b.eat()
b.eat()

sb = SongBird()
sb.sing()
sb.eat()
