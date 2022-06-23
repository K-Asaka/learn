class Secretive:
    def __inaccessible(self):
        print("あなたは私が見えない。")
    def accessible(self):
        print("秘密のメッセージ:", end="")
        self.__inaccessible()

s = Secretive()
s.accessible()
s.__inaccessible()
