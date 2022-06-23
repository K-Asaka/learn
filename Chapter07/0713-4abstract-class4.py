from abc import ABC, abstractmethod
class Talker(ABC):
    @abstractmethod
    def talk(self):
        pass

class FrequentTalker(Talker):
    def talk(self):
        print("こんにちは！")

class NightTalker:
    def talk(self):
        print("こんばんは")

nt = NightTalker()
nt.talk()
print(isinstance(nt, FrequentTalker))
print(isinstance(nt, Talker))

print(Talker.register(NightTalker))
print(isinstance(nt, Talker))
print(issubclass(NightTalker, Talker))

class Speaker:
    pass

print(Talker.register(Speaker))
print(issubclass(Speaker, Talker))
s = Speaker()
print(isinstance(s, Talker))
s.talk()
