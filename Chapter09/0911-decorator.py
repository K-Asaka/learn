class MyClass:
    @staticmethod
    def smeth():
        print('これはスタティックメソッドです')
    @classmethod
    def cmeth(cls):
        print(f'これは{cls}のクラスメソッドです')

MyClass.smeth()
MyClass.cmeth()
