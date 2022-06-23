class MuffledCalculator:
    muffled = False
    def calc(self, expr):
        try:
            return eval(expr)
        except ZeroDivisionError:
            if self.muffled:
                print('ゼロによる除算は不正な演算です')
            else:
                raise

mc = MuffledCalculator()
print(mc.calc("5/2"))
mc.muffled = True
print(mc.calc("5/0"))
mc.muffled = False
print(mc.calc("5/0"))
