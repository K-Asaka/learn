def check_index(key):
    """
    与えられたキーはインデックスとして適切か(非負の整数かどうか)をチェック
    整数でなければTypeErrorを生成、負ならばIndexErrorを生成
    (シーケンスの長さが無限なので)
    """
    if not isinstance(key, int): raise TypeError
    if key < 0: raise IndexError

class ArithmeticSequence:
    def __init__(self, start=0, step=1):
        """
        等差数列の初期化
        start   - 初項(数列の最初の項の値)
        step    - 公差(2つの隣り合った値の差)
        changed - ユーザーによって変更された値のインデックスを記憶
        """
        self.start = start
        self.step = step
        self.changed = {}
    def __getitem__(self, key):
        """
        等差数列から値を取得する
        """
        check_index(key)
        try: return self.changed[key]
        except KeyError:
            return self.start + key * self.step
    def __setitem__(self, key, value):
        """
        等差数列内の項を変更する
        """
        check_index(key)
        self.changed[key] = value

s = ArithmeticSequence(1, 2)
print(s[4])
s[4] = 2
print(s[4])
print(s[5])
