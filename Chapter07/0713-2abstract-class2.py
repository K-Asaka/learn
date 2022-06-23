from abc import ABC, abstractmethod
class Talker(ABC):
    @abstractmethod
    def talk(self):
        pass

class FrequentTalker(Talker):
    pass

FrequentTalker()
