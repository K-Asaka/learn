class WriteSmaple:
    def write(self):
        pass

obj = WriteSmaple()

try:
    obj.write
except AttributeError:
    print('このオブジェクトは書き込み可能ではない。')
else:
    print('このオブジェクトは書き込み可能である。')
