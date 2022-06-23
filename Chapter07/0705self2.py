class Bird:
    song = 'カー、カー！'
    def sing(self):
        print(self.song)

bird = Bird()
bird.sing()
birdsong = bird.sing
birdsong()
