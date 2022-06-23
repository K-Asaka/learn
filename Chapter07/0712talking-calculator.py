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
