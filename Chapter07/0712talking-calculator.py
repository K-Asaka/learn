class Calculator:
    def calculate(self, expression):
        self.value = eval(expression)

class Talker:
    def talk(self):
        print(f'こんにちは。私の値は{self.value}です。')

# 多重継承の場合、前のクラスのメソッドが、後ろのほうのクラスのメソッドよりも優先される
# CalculatorにTalkerと同名のメソッドがある場合、Calculatorのメソッドが使用される
class TalkingCalculator(Calculator, Talker):
    pass

tc = TalkingCalculator()
tc.calculate('1 + 2 * 3')
tc.talk()


print(hasattr(tc, 'talk'))
print(hasattr(tc, 'fnord'))

print(callable(getattr(tc, 'talk', None)))
print(callable(getattr(tc, 'fnord', None)))

setattr(tc, 'name', '山田太郎')
print(tc.name)
