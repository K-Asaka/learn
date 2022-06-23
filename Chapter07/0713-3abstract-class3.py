from abc import ABC, abstractmethod
class Talker(ABC):
    @abstractmethod
    def talk(self):
        pass

class FrequentTalker(Talker):
    def talk(self):
        print("こんにちは！")

ft = FrequentTalker()
print(isinstance(ft, Talker))
ft.talk()

print(isinstance(ft, FrequentTalker))
