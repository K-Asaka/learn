# 学習記録用リポジトリ

Python 基礎&実践プログラミング


```
repr("str\nstr")
```
式の表記に則った方式でそのまま表示

バイト列で表現された文字列を扱う場合  
```
b'Hello world.'
```

raw文字列  
```
r'Hello,\nworld.'
r'''Let's go!'''
```


## 2章メモ

スライス指定  
```
s[p:q]
```
シーケンスsのインデックスpからq-1までの要素を返す

```
s[:]
```
シーケンスsの全要素を返す

```
s[p:q:i]
```
インデックスpの要素から始め、インデックスq-1の要素まで、i-1個をスキップした要素を返す(iは1以上の場合)。iが1のときはスキップしない

シーケンスの加算  
```
[1, 2, 3] + [4, 5, 6]
```

シーケンスの乗算  
```
'python' * 5
"パイソン" * 3
[42] * 10
```

シーケンスの初期化  
```
sequence = [None] * 10
```
何も具体的な値が入っていない10個の要素を確保したリストの作成

メンバーシップテスト  
演算子inを使う
```
users = ['mlh', 'foo', 'bar']
input('ユーザー名を入力してください: ') in users

subject = '$$$ 大金持ちになるチャンスです!!! $$$'
'$$$' in subject
```

文字列をリストに変換する(リストを文字列に変換する)
```
l = list("こんにちは")
print(l)
print(''.join(l))
```

要素のないところには代入できない。空の要素を作ってから代入
```
list = [None] * 101
list[100] = '101番目'
list[100]
```

要素の削除
```
names = ['太郎', '花子', 'ジョン', 'メアリー', '和宏']
del names[2]
names
```

スライスに対する代入
```
name = list('Perl')
name
name[2:] = list('ar')
name
```

元とは違う長さのシーケンスでスライスを置き換える
```
name = list('Perl')
name[1:] = list('ython')
name
```

スライスへ挿入
```
numbers = [1, 5]
numbers[1:1] = [2, 3, 4]
numbers
```

空のスライスとの置き換えで要素の削除
```
numbers = [1, 2, 3, 4, 5]
numbers[1:4] = []
numbers
```

文字列フォーマット演算子
```
format = "こんにちは、%sさん。%sですか？"
value = ('花子', 'お元気')
format % value
```

テンプレート文字列
```
from string import Template
tmpl = Template("こんにちは、$whoさん。$whatですか？")
tmpl.substitute(who="太郎", what="暑い")
```

置換フィールド名
```
"{foo} {} {bar} {}".format(1, 2, bar=4, foo=3)
```

与えられた値そのものを使わず、通常のPythonコードと同じように、その一部にアクセスする例
```
"{name[0]}".format(name=fullname)
tmpl = "モジュール{mod.__name__}はπの値を{mod.pi}と定義しています。"
tmpl.format(mod=math)
```

基本的な変換
関数str、repr、asciiによる変換
```
print("{pi!s} {pi!r} {pi!a}".format(pi="π"))
```
s:str関数は一般的に値の自然な文字列表現を生成する。  
r:repr関数は与えられた値のPython表現(Python representation)を生成しようとする
。  
a:ascii関数はASCIIエンコーディングで許されている文字だけの表現を生成する。  

変換する値の型を指定する
```
"The number is {num:f}".format(num=42) 
"The number is {num:b}".format(num=42) 
```

表示幅
```
"{num:10}".format(num=3)
"{name:10}".format(name="Bob")
```

小数部の桁精度
```
"{pi:.2f}はパイを食べる日です。".format(pi=math.pi)
```

表示幅と精度の組み合わせ
```
"{pi:10.2f}".format(pi=math.pi)
```

整数の3桁ごとの区切りの指定
```
"1グーゴル(googol)の値は{:50,}に等しい。".format(10**100)
```
表示幅と精度と組み合わせる時は、表示幅と精度のピリオドの間に「,」を入れる

数値の前を0で埋める。表示幅の前に0を指定
```
'{:010.2f}'.format(pi)
```

充填文字(fill character)
```
"{:$^15}".format(" 大当たり！ ")
```

=を使った充填文字
```
print('{0:10.2f}\n{1:=10.2f}'.format(pi, -pi))
```

正数に符号をつける
```
print('{0:-.2f}\n{1:-.2f}'.format(pi, -pi))
print('{0:+.2f}\n{1:+.2f}'.format(pi, -pi))
print('{0: .2f}\n{1: .2f}'.format(pi, -pi))
```

数値の種類を表す記号を追加
```
"{:#b}".format(42)
"{:#o}".format(42)
"{:#x}".format(42)
```

小数点以下の0を表示
```
"{:#g}".format(42)
```
