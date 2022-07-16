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

文字列のメソッド  
center
```
"The Middle by Jimmy Eat World".center(39)
"The Middle by Jimmy Eat World".center(39, "*")
```

find
```
'With a moo-moo here, and a moo-moo there'.find('moo')
'隣の客はよく柿食う客だ'.find('客')
title = "Monty Python's Flying Circus"
title.find('Monty')
title.find('Python')
title.find('Zirquss')
```

検索の開始点(と終了点)を指定
```
subject = '$$$ Get rich now!!! $$$'
subject.find('$$$')
subject.find('$$$', 1)
subject.find('!!!')
subject.find('!!!', 0, 16)
```

join  
結合しようとするシーケンスの要素はすべて文字列でなければならない。
```
seq = [1, 2, 3, 4, 5]
sep = '+'
sep.join(seq)   # エラー
seq = ['1', '2', '3', '4', '5']
sep = '+'
sep.join(seq)
dirs = '', 'usr', 'bin', 'env'  # ディレクトリのリスト
'/'.join(dirs)  # UNIX用のパスを生成
print('C:' + '\\'.join(dirs))   # Windows用のパスを生成
```

lower
```
"Monty Python's Flying Circus".lower()
name = 'Monty'
names = ['monty', 'python', 'flying']
if name.lower() in names: print('見つかった!')
...
```

title
```
"that's all folks".title()
```

capwords
```
import string
string.capwords("that's all, folks")
```

replace
```
'This is a test. That is also a test'.replace('is', 'eez')
```

split
```
'1+2+3+4+5'.split('+')
'/usr/bin/env'.split('/')
'Using   the   default'.split()
```

strip
```
'    internal whitespace  is  kept    '.strip()
'　　　全角のスペースも　前後のものは削除されるが...　　　'.strip()
'*** SPAM * for * everyone!!! ***'.strip(' *!') # 削除したい文字を含む文字列を引数に指定
'　スペースは全角も半角も削除 '.strip('　 ')
```

translate
```
table = str.maketrans('cs', 'kz')
'this is an incredible test'.translate(table)
table = str.maketrans('cs', 'kz', ' ')
'this is an incredible test'.translate(table)
```

dict  
シーケンスから辞書を作成
```
items = [('名前', '太郎'), ('年齢', 42)]
d = dict(items)
d
d['名前']
```
キーワード引数で辞書を作成
```
d = dict(名前='太郎', 年齢=42)
```
空の辞書を作成
```
e = dict()
```

clear
```
d = {}
d['name'] = 'Gumby'
d['age'] = 42
d
returned_value = d.clear()
d
print(returned_value)
```
次のようなコードの場合にclearを使う
```
x = {}
y = x
x['key'] = 'value'
y
x = {}
y
#-----
x = {}
y = x
x['key'] = 'value'
y
x.clear()
y
```

copy
```
x = {'username': 'admin', 'machines': ['foo', 'bar', 'baz']}
y = x.copy()
y['username'] = 'mlh'
y
x
y['machines'].remove('bar')
y
x
```

deepcopy
copyでは辞書内の参照オブジェクトは同じオブジェクトを指している。それを回避するためのメソッド。
```
from copy import deepcopy
x = {'username': 'admin', 'machines': ['foo', 'bar', 'baz']}
z = deepcopy(x)
z['username'] = 'mlh'
z
x
z['machines'].remove('bar')
z
x
```

fromkeys  
与えられたキーから新たな辞書を作成する
```
# 冗長な書き方
{}.fromkeys(['name', 'age'])
{}.fromkeys(['名前', '年齢'])
# 一般的な書き方
dict.fromkeys(['name', 'age'])
dict.fromkeys(['名前', '年齢'])
dict.fromkeys(['name', 'age'], '(unknown)')
dict.fromkeys(['名前', '年齢'], '(不詳)')
```

get
```
d = {}
print(d['name'])  # エラー
print(d.get('name'))
print(d.get('name', 'N/A'))
```

items  
返される値は辞書ビューと呼ばれる特殊な型。
```
d = {'タイトル': 'Pythonウェブサイト', 'url': 'https://www.python.org', 'スパム数': 0}
d.items()
ditems = d.items()
len(ditems)
('スパム数', 0) in ditems
list(d.items())
```

keys
```
d.keys()
```

pop
```
d = {'x': 1, 'y': 2}
d.pop('x')
d
```

popitem
```
d = {'タイトル': 'Pythonウェブサイト', 'url': 'https://www.python.org', 'スパム数': 0}
d.popitem()
d
d.popitem()
d
```

setdefault  
指定のキーに対応する値を返す。値が無ければ設定する
```
d = {}
d.setdefault('名前', '＜不明＞')
d
d['名前'] = '太郎'
d.setdefault('名前', '＜不明＞')
d
d = {}
d.setdefault('名前')    # キーのみを指定。Noneが返る
d
```

update  
別の辞書を指定し、別の辞書の項目と同じキーの項目があれば辞書を更新し、その項目がなければ辞書に追加する。
```
d = {'タイトル': 'Pythonウェブサイト', 'url': 'https://www.python.org', '更新日時': 'Mar 14 22:09:15 PST 2019'} 
x = {'タイトル': 'Python言語のウェブサイト'}
d.update(x)
d
```

values  
辞書内にあるすべての値(value)を辞書ビューとして返す。
```
d = {}
d[1] = 1
d[2] = 2
d[3] = 3
d[4] = 4
d.values()
```

printの補足  
,で区切った2つ以上の式を出力できる。
```
print('年齢:', 42)
```
文字列の間にスペースを入れたくない場合
```
print('年齢:', 42, sep="")
```

インポート時の別名
```
import math as foobar
foobar.sqrt(4)
from math import sqrt as foobar
foobar(4)
```

シーケンスアンパック(sequence unpacking)あるいはイテラブルアンパック(iterable unpacking)  
一連の値の列(シーケンス)を一連の変数の列にアンパックする(解いて取り出す)
```
x, y, z = 1, 2, 3
print(x, y, z)
x, y =y, x
print(x, y, z)
x, y, z = 1, 2, 3
x, y, z = y, z, x
print(x, y, z)
values = 1, 2, 3
values
x, y, z = values
x
person = {'名前': 'ロビン', 'ガールフレンド': 'マリオン'}
key, value = person.popitem()
key
value
a, b, *rest = [1, 2, 3, 4]
rest
name = "アルバス・パーシバル・ウルフリック・ブライアン・ダンブルドア"
first, *middle, last = name.split("・")
middle
```

連鎖代入
```
x = y = somefunction()
```

累算代入(augmented assignment)
```
x = 2
x += 1
x *= 2
x
x = 'foo'
x += 'bar'
x *= 2
x
```

真偽値  
以下は全て「偽」と解釈される。
```
False
None
0
""
()
[]
{}
```

同一性演算子 is
```
x = y = [1, 2, 3]
z = [1, 2, 3]
x == y
x == z
x is y
x is z

x = [1, 2, 3]
y = [2, 4]
del x[2]
y[1] = 1
y.reverse()
x is not y
x == y
```

文字列およびシーケンスの比較  
文字列は、Unicodeの「コードポイント」で比較される。
アルファベットの文字列は、アルファベット順に並べたときの順序によって大小が決まる。(大文字よりも小文字の方が大きいと判定される)
```
"alpha" < "beta"
"alpha" < "ABC"
"あ" < "ア"
"ア" < "亜"
"あい" < "おい"
```

文字のコードポイントはord関数で確認できる。コードポイントから文字を知る関数はchr。
```
ord("あ")
ord("ア")
ord("a")
chr(12354)
chr(12450)
chr(97)
```

大文字と小文字の違いを無視して比較したい場合
```
"a".lower() < "B".lower()
```

アサーション  
プログラムが正しく動作するにはある条件が満たされなければならないとわかっているとき、その条件を判定するチェックポイントとしてassert文を配置する。
```
age = 10
assert 0 < age < 100
age = -1
assert 0 < age < 100
age = -1
assert 0 < age < 100, 'ageは年齢を表す数値でなければならない'
```

forループ  
すべての要素を対象にして、コードブロックを実行する。
```
words = ['this', 'is', 'an', 'ex', 'parrot']
for word in words:
    print(word)
```

範囲を生成する。
```
range(0, 10)
list(range(0, 10))
range(10)
list(range(10))
```

```
for number in range(1, 101):
    print(number)
````

辞書のイテレーション
```
d = {'x': 1, 'y': 2, 'z': 3}
for key in d:
    print(key, 'は', d[key], 'に対応')
```
```
for key, value in d.items():
    print(key, 'は', value, 'に対応')
```

並列イテレーション  
2つのリストを並列に繰り返したいときは組み込み関数zipを使う。zipはシーケンスをジッパーのように組み合わせ、タプルのシーケンスを返す。
```
names = ['渋谷', '恵比寿', '上野', '巣鴨']
ages = [12, 45, 32, 102]
list(zip(names, ages))
for name, age in zip(names, ages):
    print(name, 'さんは', age, '歳です')
```
zip関数は、シーケンスをいくつでも好きなだけ組み合わせられる。
シーケンスの長さが異なる場合は、最も短いシーケンスが終わりに達すると全体も終了する。
```
list(zip(range(5), range(100000000)))
```

reversedとsorted
```
sorted([4, 3, 6, 8, 3])
sorted('Hello, world!')
list(reversed('Hello, world!'))
''.join(reversed('Hello, world!'))
sorted('こんにちは、皆さん！')
''.join(reversed('こんにちは、皆さん！'))
```

リスト内包表記
```
[e for x in range(n)]
# 0～n-1の整数に対してeを実行し、リストを生成
[e for x in range(n) if c]
# 0～n-1の整数に対してcが真ならeを実行し、リストを生成
[e for x in range(n) for y in range(n)]
# 0～n-1の2つの整数(xとy)に対してeを実行し、リストを生成
```
```
[x * x for x in range(10)]
[x * x for x in range(10) if x * x % 3 == 0]
[(x, y) for x in range(3) for y in range(3)]
```

pass  
「何もする必要がない」ことを記述するのに使う。
```
if name == '太郎':
    print('ようこそ！')
elif name == '花子':
    # まだ書けていない...
elif name == '悪代官':
    print('アクセスは拒否されました')
```
上のような空のブロックは文法違反になりエラー。
このようなコードの時に空ブロックへpassを記述する。


del  
オブジェクトへの参照と参照元の変数名を削除する。
```
x = 1
del x
x   # エラー
x = ["Hello", "world"]
y = x
y[1] = "Python"
x
del x   # 変数名のみ削除
y
```
Pythonには値を削除する方法がない。
値が使われなくなるとPythonインタプリタが必ず自分で削除する。


exec  
exec関数は文字列を実行するのに使う。  
多くの場合変数の保管場所である「名前空間」も渡す。
名前空間を指定しないと、周囲の名前空間が「汚染」されることになり、周囲の変数の意味が変わってしまう。
```
exec("print('Hello, world!')")
# 汚染
from math import sqrt
exec("sqrt = 1")
sqrt(4) # sqrt関数が変数により上書きされエラーになる
```
exec関数には、名前空間として2番目の引数に辞書を渡す。
この辞書は、コードとなる文字列のための名前空間として機能する。
```
from math import sqrt
scope = {}
exec('sqrt = 1', scope)
sqrt(4)
scope['sqrt']
len(scope)
scope.keys()
```

eval  
execに似た組み込みの関数。
evaluate(評価する)の略。  
文字列の中に書かれたPythonの「式」を評価し、その結果の値を返す。
```
eval(input("数式を入力してください: "))
数式を入力してください: 6 + 18 * 2
```
execと同様にevalに対しても名前空間を渡せるが、文で変数のバインドを変更する(再バインドする)こととは違って、式において同様の再バインドが必要となることはない。
しかし、再バインドは起こり得るため、信頼できないコードに対してevalを行うのはexecを行うのと同様に危険。


スコープの初期化  
execやevalに名前空間を渡す場合、実際に名前空間が使用される前に値を入れておくこともできる。
```
scope = {}
scope['x'] = 2
scope['y'] = 3
eval('x * y', scope)
```
execやexecの呼び出しに使われたスコープは、別の呼び出しで再度使うことができる。
```
scope = {}
exec('x = 2', scope)
eval('x * x', scope)
```

## 関数による抽象化

標準の組み込み関数callableを使えば、あるものを呼び出すことが可能かどうかわかる。
```
import math
x = 1
y = math.sqrt
callable(x)
callable(y)
```

関数の定義にはdef文(関数定義文)を使う。
```
def hello(name):
    return 'こんにちは、' + name + 'さん！'
```

関数の「ドキュメント」  
関数に説明を残したい場合、コメントを付けておくことができる。
コメントの先頭には「#」を書く。  
この意図で注釈を残しておく方法がもう1つある。  
関数定義の冒頭に文字列として書いておくという方法。
ドキュメンテーション文字列(docstring)と呼ばれるもので、関数の一部として保存され後で参照できる。
```
def square(x):
    '数xの自乗を計算する'
    return x * x
```
ドキュメンテーション文字列のアクセス方法。
```
square.__doc__
```
__doc__は属性(attribute)。
属性名についている「__」(アンダースコアの連続)は、それが特別な属性(特殊属性あるいはマジック属性)であることを表している。

helpという名前の特殊な組み込み関数も有用。
```
help(squre)
```


戻り値の有無  
値を返さない関数は、一部の言語(たとえばPascal)では「手続き(procedure)」などといった別の名前が付いているが、Pythonでは値を返しても返さなくても関数と呼ぶ。
```
def test():
    print('これは出力される')
    return
    print('これは出力されない')
x = test()
x
print(x)
```
何を返すのか指定しなかった場合は、Noneを返す。


引数の変更  
関数は引数を介して値を受け取る。
このとき、受け取った引数に対して関数内で新しい値を代入しても、関数の外の世界には何の影響も与えない。
```
def try_to_change(n):
    n = '太郎さん'

name = '花子さん'
try_to_change(name)
name
```

文字列(および数値やタプル)はイミュータブルであり、変更できない。
リストのようなミュータブル(変更可能)なデータ構造体が引数に指定された場合はバインドされたリストを変更する。
```
def change(n):
    n[0] = '太郎さん'

names = ['花子さん', '花江さん']
change(names)
names
```

これを避けたければリストのコピーを作成する。
リスト全体のスライスを作成すれば、リストのコピーが得られる。
```
names = ['花子さん', '花江さん']
n = names[:]
n is names
n == names
```
ここでnを変更してもnamesは影響を受けない。
```
change(names[:])
names
```
こうすれば引数nにはコピーが入るため、元のリストは安全。


詳細の隠蔽  
人名を保存しておき、ファーストネーム、ミドルネーム、ラストネームで人を探し出せるようなプログラムを書きたいとする。
次のようなデータ構造を使うことにする。
```
storage = {}
storage['first'] = {}
storage['middle'] = {}
storage['last'] = {}
```
この3つのキーの下位に別の辞書を作る。
この下位辞書では、名前(ファーストネーム、ミドルネーム、ラストネーム)をキーとし、人名のリストを値として挿入する。
```
me = 'Magnus Lie Hetland'
storage['first']['Magnus'] = [me]
storage['middle']['Lie'] = [me]
storage['last']['Hetland'] = [me]
```
登録されている人の中でLieというミドルネームをもった人全員のリストが欲しければ次のようにする。
```
storage['middle']['Lie']
```
この構造に人名を追加していくのは面倒。特に同じ姓や名の人が多くなってくると、その名前の下にすでに保存されているリストを延長していかなければならない。
```
my_sister = 'Anne Lie Hetland'
storage['first'].setdefault('Anne', []).append(my_sister)
storage['middle'].setdefault('Lie', []).append(my_sister)
storage['last'].setdefault('Hetland', []).append(my_sister)
storage['first']['Anne']
storage['middle']['Lie']
```
このような更新用コードがたくさん入った大きなプログラムを書くことを想像すると、すぐに手に負えなくなることが考えられる。
抽象化のポイントは、更新の詳細の泥臭い部分を覆い隠すこと。
関数を使うのがその方法の1つ。
```
def init(data):
    data['first'] = {}
    data['middle'] = {}
    data['last'] = {}
```
次のように使う。
```
storage = {}
init(storage)
storage
```
関数が初期化をしてくれるため、コードは読みやすくなった。  
名前を保存する関数を書く前に、名前のリストを探し出す(lookupする)関数を書く。
```
def lookup(data, label, name):
    return data[label].get(name)
```
lookup関数を使えば、ラベルと名前(たとえば'middle'と'Lie')を与えると、フルネームのリストが返される。
```
lookup(storage, 'middle', 'Lie')
```
返されるリストはstorageに保存されてるものと同じ。
リストを変更すると、その変更はstorageにも及ぶ。  
名前を保存する関数を書く。
```
def store(data, full_name):
    names = full_name.split()
    if len(names) == 2: names.insert(1, '')
    labels = 'first', 'middle', 'last'
    for label, name in zip(labels, names):
        people = lookup(data, label, name)
        if people:
            people.append(full_name)
        else:
            data[label][name] = [full_name]
```
ここまでに作成した関数を呼び出す。
```
MyNames = {}
init(MyNames)
store(MyNames, 'Magnus Lie Hetland')
lookup(MyNames, 'middle', 'Lie')
store(MyNames, 'Robin Hood')
store(MyNames, 'Robin Locksley')
lookup(MyNames, 'first', 'Robin')
store(MyNames, 'Mr. Gumby')
lookup(MyNames, 'middle', '')
```
こういったアプリケーションの場合は、オブジェクト指向の考え方を用いたほうがわかりやすくなることが多い。


イミュータブルな引数
Pythonでは呼び出し側で変数の値を変更したい場合は、関数から返ってくる値を利用するのが普通。
変数の値を1だけ増加させるinc関数(increaseの短縮形)は次のように書く。
```
def  inc(x): return x + 1
foo = 10
foo = inc(foo)
foo
```
リストに「ラッピング」してしまうと、引数を変更することができる。
```
def inc(x): x[0] = x[0] + 1
foo = [10]
inc(foo)
foo
```


キーワード引数とデフォルト値  
ここまでに使ってきた引数は渡される位置によって役割が決まるため位置引数と呼ばれる。
キーワード引数(名前が付いた引数)を使うこともできる。


可変長引数  
「\*」(アスタリスク)を付けた引数をもつ関数を定義することで、可変長の引数(いくつでも指定できる引数)を使うことができる。
引数の前に「*」が付くと、すべての値は1つのタプルに格納される。  
「\*」付きの変数には残りの位置引数全部が入る。
対象の引数がなければ、paramsは空のタプルになる。  
「\*」付き引数を最後以外の場所に置くこともできるが、最後の引数を名前で特定する必要がある。
キーワード引数は、「\*」付き引数には入らない。
しかし、**を付ければ、すべての引数を集めることができる。


逆の処理  
関数を定義するときではなく、呼び出す時に「*」を付ける。
*付きの変数が最後ならば、引数リストの一部として使える。
```
def add(x, y):
    return x + y

params = (1, 2)

add(*params)
```

**演算子を使うと、辞書に対しても同じことができる。
```
def hello_3(name='皆さん', greeting='こんにちは'):
    print(f'{name}、{greeting}！')

params = {'name': '次郎さん', 'greeting': 'お久しぶりです'}
hello_3(**params)
```
\*(あるいは**)は関数の定義でも呼び出しでも使用できて、タプルや辞書をうまく処理してくれる。


スコープ  
変数は「名前を介して値を参照する仕組み」だと考えることができる。
変数についても、暗黙的な「見えない辞書」が存在している。
varsという組み込み関数で、「見えない辞書」を返すことができる。
```
x = 1
scope = vars()
scope['x']
scope['x'] += 1
x
```
見えない辞書のことを「名前空間(namespace)」やスコープ(scope)と呼ぶ。

```
def foo(): x = 42

x = 1
foo()
x
```
fooが変数xを変更(再バインド)しているが、最終的な結果を見ると、xの値は変わらない。
fooを呼び出した時に新しく名前空間が作成され、fooの内部のブロックではそれが使われるから。
関数の内側で使われる変数を局所変数(ローカル変数)と呼ぶ。
その反対は大域変数あるいはグローバル変数と呼ばれる。  
引数は局所変数と同じように扱われるため、大域変数と同じ名前の引数があっても互いに影響はない。
```
def output(x) : print(x)

x = 1
y = 2
output(y)
```

関数の内部から大域変数にアクセスしたい場合は難しくない。
```
def combine(parameter): print(parameter + external)

external = 'ベリー'
combine('ラズ')
combine('ブルー')
```
関数をまたいで大域変数を参照するのはバグの原因になることがあるため注意が必要。


シャドーイング  
アクセスしたいと思う大域変数と同じ名前の局所変数が存在していると、直接アクセスできないという問題が生じる。大域変数は局所変数の影に隠れてしまう。これをシャドーイング(shadowing)と呼ぶ。  
このような場合、globals関数を使って大域変数にアクセスできる。
```
def combine(parameter):
    print(parameter + globals()['parameter'])

parameter = 'ベリー'
combine('ラズ')
```
関数内部で変数に値を代入すると、自動的にローカル変数になってしまう。
Pythonにローカル変数ではないことを伝えるには、globalであることを宣言する。
```
x = 1
def change_global():
    global x
    x = x + 1

change_global()
x
```


スコープの入れ子  
Pythonの関数は入れ子にできる。関数の中で別の関数を定義可能。
```
def foo():
    def bar():
        print("Hello, world!")
    bar()
```

関数の入れ子は、関数を生成するために関数を使う場合に便利。
```
def multiplier(factor):
    def multiplyByFactor(number):
        return number * factor
    return multiplyByFactor
```
ある関数が別の関数の中にあり、外側の関数が内側の関数を返している。つまり、関数自体が返されている。ここでは内側の関数は呼び出されていない。重要なことは、返された関数は定義されたスコープへのアクセスが継続的に可能だということ。言い換えれば、関数はその環境(及びそれに関連する局所変数)を自分の中に保持している。  
外側の関数が呼び出されるたびに内側の関数は新たに定義され、そのたびに変数factorの値は新たな値になる。Pythonのスコープが入れ子になっても内側の関数からアクセスできる。
```
double = multiplier(2)
double(5)
triple = multiplier(3)
double(3)
multiplier(5)(4)
```
multiplyByFactorのような中に封入されたスコープを持っている関数のことを「クロージャー(closure)」と呼ぶ。通常は、外側のスコープの変数を再バインドできないが、キーワードnonlocalを使って再バインドできる。これはglobalと同じように使えて、外側の(グローバルではない)スコープの変数に代入できるようになる。


再帰  
自分自身を呼び出す関数を定義できる。
```
def recursion():
    return recursion()
```
この関数は無限再帰する。  
再帰関数は次のような2つの部分に分けて定義する必要がある。

* 終了条件部分：「最小の問題」を処理する箇所。再帰呼び出しをせずに直接的に値を返す
* 再帰条件部分：「より小さな問題」を処理するための再帰呼び出しを含む

問題を小さな部分に分解していけば最終的に最小の問題に行き着き、それに対しては終了条件が満たされるので、再帰が永遠に続くことはない。


階乗と累乗  
「古典的」と言える再帰関数を確認する。
階乗(factorial)の計算。nの階乗のことをn!と書き、次のように計算される。
```
n! = n × (n - 1) × (n - 2) × …… × 1
```

もう1つ別の例を見る。組み込みのpow関数や演算子**を使えば累乗(power)の計算を行えるが、これと同じような関数を自作する。
これも再帰的な定義が可能。

* a^0は1である
* a^nは、a × a^n-1である(n > 0)


関数の扱い  
Pythonでは、文字列や数値、シーケンスなどと同じように、関数を変数に代入したり、他の関数の引数として指定したり、他の関数の戻り値として指定したりできる。
SchemeやLispほど関数に重きを置いたコードが書かれることはないが、Pythonでも関数型言語のようなコードを書くことができる。
```
list(map(str, range(10)))
```

Pythonにはラムダ式と呼ばれる機能があり、簡単な関数をインラインで定義できる。
```
list(filter(lambda x: x.isalnum(), seq))
```


## オブジェクト指向

割愛


## 例外

例外的な自体を表すのに例外オブジェクトを使う。
エラーに遭遇すると、例外を生成する。そのオブジェクトが補足されないと、プログラムはトレースバックと呼ばれるエラーメッセージを出力して終了する。
```
>>> 1/0
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ZeroDivisionError: division by zero
```

独自の例外の生成  
raise文  
例外を生成するには、raise文を使い、Exceptionクラス(のサブクラス)またはそのインスタンスを引数として指定する。
```
raise Exception

raise Exception('ハイパードライブの過負荷')
```

例外クラスの作り方は他のクラスと同じだが、必ずExceptionの(直接あるいは間接の)サブクラスとする。
```
class SomeCustomException(Exception): pass
```

例外の補足  
try/except文を使うことで、例外を処理(補足)できる。
try/exceptを使えばエラーハンドラは1つだけで済む。


引数なしのraise  
例外を補足はしたものの、そのまま上位のコードに処理を任せたいときは、raiseを引数なしで呼び出す。
例外を補足したもののそこでは処理できない場合は、別の例外を生成して上のレベルに処理を任せることになる。その場合、その時点の状況が例外のコンテキスト(文脈、状況)として記憶され、最終的なエラーメッセージに反映される。  
raise ... from ... という形式の文を使えばコンテキストを自分で指定できる。
from Noneを指定すると、コンテキストを抑制できる。


複数のexcept節  
複数の例外を補足するには、try/except文に別のexcept節を追加する。


1つのブロックでの複数の例外の補足  
1つのブロックで2種類以上の例外を補足したければ、例外の種類をタプルにして指定する。


オブジェクトの補足  
except節で例外オブジェクト自体にアクセスしたい場合は、as ...を追加する。


すべてをキャッチ  
すべての例外を補足するには、except節に例外クラスを指定しないようにする。


else節  
条件文やループと同じように、try/except文にelse節を追加できる。


finally節  
例外が発生した後の後始末をするには、finally節をtry節と組み合わせて使う。


例外と関数  
例外はそれが起こった関数で補足されないと、補足されるまで上のレベルの関数へと上昇(バブルアップ)していく。
最終的にはプログラムのトップレベル(グローバルスコープ)に到達する。そこにも例外処理ハンドラがない場合、プログラムはスタックトレースを表示して停止する。


ifか例外か  
if/elseを使うのが自然だと思えるようなケースでも、try/exceptを使ったほうがうまく実装できる場合がある。
また、オブジェクトに特定の属性があるかどうかチェックする際にもtry/exceptが有用。


警告  
実行の過程でちょっとした異常が発生した場合に警告したいときは、warning(ウォーニング)モジュールのwarn関数を使う。
```
from warnings import warn
warn("何かここのところがちょっと嫌な感じ。")
```

同じモジュールのfilterwarnings関数を使うことで、一部あるいはすべての警告を除去(フィルター)できる。
```
from warnings import filterwarnings
filterwarnings("ignore")
warn("誰かいるかい？")
filterwarnings("error")
warn("何か、メチャクチャ変だぞ！")
```

警告を生成する際、引数にはほかの例外や「警告カテゴリ」を指定できる。
指定する例外はWarningのサブクラスでなければならない。
ここで指定した例外は、特定種類の警告を除去するために使うこともできる。
```
filterwarnings("error")
warn("この関数はとても古い...", DeprecationWarning)

filterwarnings("ignore", category=DeprecationWarning)
warn("非推奨警告をもうひとつ", DeprecationWarning)
warn("別の警告")
```

## 特殊メソッド、プロパティ、イテレータ、ジェネレータ

コンストラクタ  
オブジェクトを初期化するためのメソッド。
```
def __init__(self):
```

コンストラクタとオーバーライド  
スーパークラスのメソッドをオーバーライド(上書き)することで、継承された振る舞いを変更(カスタマイズ)できる。
オーバーライドはコンストラクタにとって重要な概念。新たに生成されたオブジェクトの状態を初期化するためにあるが、ほとんどのサブクラスは、スーパークラスの初期化コードに加えて、独自の初期化コードを必要とする。  
あるクラスのコンストラクタをオーバーライドするなら、スーパークラス(継承元のクラス)のコンストラクタも呼び出す必要がある。


super  
スーパークラスで初期化処理をしてもらうには、super().__init__()を呼び出す。

シーケンスとマッピングの基本プロトコル  
シーケンスとマッピングはアイテム(item)の集合。基本的振る舞い(プロトコル)を実行するには、特殊メソッドの実装が必要。オブジェクトが変更不可であれば特殊メソッドを2つ実装し、変更可能であれば4つ実装する。

* __len__(self)  
アイテムの個数を返す。シーケンスの場合は「要素の個数」、マッピングの場合は「キーと値の組の個数」。
__len__がゼロを帰す場合(そして、__nonzero__メソッドを実装していなければ)、オブジェクトがブール値として評価される文脈では、Falseとして扱われる(空のリスト、空のタプル、空文字列、空の辞書の場合と同様)

* __getitem__(self, key)  
与えられたキー(key)に対応する値を返す。シーケンスであれば、キーは0からn-1までの整数(nはシーケンスの長さ。負数も指定可能)。マッピングの場合、任意のキーを指定できる。

* __setitem__(self, key, value)  
値(value)をキー(key)に関連づけた形で保存する。後ほど__getitem__で取得可能。
変更可能なオブジェクトに対してのみ定義する。

* __delitem__(self, key)  
オブジェクトの一部に対して__del__文が使われ、キー(key)に関連づけられた要素を消去しなければならない時に呼び出される。これも、変更可能なオブジェクトに対してのみ(全部に対してではなく、消去を可能にしたい一部のアイテムに対してのみ)定義する。

collectionsモジュールのドキュメントを参照。


list、dict、strのサブクラス化  
組み込みの型そのものをサブクラス化することができる。


プロパティ  
Pythonではアクセッサを隠して、すべての属性を同じように見せることができる。
アクセッサによって定義されるそうした属性のことをプロパティ(property)と呼ぶ。
プロパティを作成する仕組みは2つある。  
property関数は新形式のクラスにしか使えない。  
2つのアクセッサ関数(最初にゲッター、次にセッター)を引数としたproperty関数によりプロパティが生成され、そのプロパティに名前をバインドする。
それが済めば、属性がどのように実装されているかを考える必要はなくなり、同じ方法で取り扱うことができる。


スタティックメソッドとクラスメソッド  
スタティックメソッドは引数selfなしで定義され、クラス名を指定して直接呼び出せる。
クラスメソッドは、通常clsという名前のselfに似た引数とともに定義される。
クラスメソッドをクラスのオブジェクトを使って直接呼び出せるが、その場合、引数clsは自動的にそのクラスにバインドされる。
デコレータ(decorator)と呼ばれる構文を用いる。
演算子@を使って、メソッド(あるいは関数)の前に1個以上のデコレータを並べる(並べたものは逆順に適用される)。


__getattr__および__setattr__と関連メソッド  
オブジェクトの属性に対するすべてのアクセスをインターセプトすることが可能。
属性にアクセスがあったときにコードが実行されるようにするには、次の4つの特殊メソッドを使う。

* __getattribute__(self, name)  
属性nameがアクセスされた時に自動的に呼び出される(これが正しく動作するのは新形式のクラスのみ)。

* __getattr__(self, name)  
属性nameがアクセスされ、そのような属性がなかったときに自動的に呼び出される。

* __setattr__(self, name, value)  
属性nameに値valueをバインドしようとしたときに自動的に呼び出される。

* __delattr__(self, name)  
属性nameを消去しようとしたときに自動的に呼び出される。

__setattr__に無限ループに陥る危険があるように、__getattribute__にも同じ危険がある。
__getattribute__は(新形式のクラスで)属性へのすべてのアクセスをインターセプトする。
__dict__へのアクセスもインターセプトしてしまう。
__getattribute__内でselfの属性に安全にアクセスするためには、(superを使って)スーパークラスの__getattribute__メソッドを使うこと。


イテレータ  
「イテレートする」(あるいは「イテレーションする」)とは、何かを繰り返す(ループする)ことを表す。__iter__メソッドを実装しているオブジェクトならばイテレーションが可能。  
__iter__メソッドはイテレータを返す。イテレータとは、引数なしで呼び出せる__next__というメソッドを持ったオブジェクトのこと。
__next__メソッドを呼び出すと、イテレータは「次の値」を返す。
返す値がないなら、例外StopIterationを生成する。  
nextという名前の組み込み関数があり、itをイテレータオブジェクトとすると、next(it)はit.__next__()と同じになる。


ジェネレータ  
yield文を含む関数はすべてジェネレータと呼ばれ、通常の関数とは違った動きをする。
return文のように値を1つ返すのではなく、複数の値を1つずつ作り出す(yieldする)というところ。
yield文によって値が1つ生成(yieldされるたびに、関数はフリーズする)されるたびに、関数は「フリーズ」する。実行を再開する時は停止したところから開始する。

```
def simple_generator():
    yield 1

simple_generator
simple_generator()
next(simple_generator())
```
ジェネレータは、「ジェネレータ関数」と「ジェネレータ・イテレータ」という、2つの別々のコンポーネントから成り立っている。
ジェネレータ関数は、yieldを含んだdef文で定義されるもの。ジェネレータ・イテレータはこの関数が返すもの。


## モジュール

```
import math
math.sin(0)
```

Pythonプログラムもモジュールとしてインポートできる。
ファイルを保存する場所も重要。
`C:\python`または`~/python`に保存するとして例を挙げる。

```python:hello.py
# hello.py
print("Hello, world!")
```

```
import sys
sys.path.append('C:\python')
#
# または
# sys.path.append('/home/[ユーザー名]/python')
# か
# os.path.expanduser('~/python')
# sys.pathには文字列'~/python'はそのまま追加できない
#
import hello
```

モジュールをインポートすると、そのモジュール内のコードが実行される。しかし、もう一度インポートしようとしても何も起こらない。
本来モジュールはインポートされた際に何かを行うためのものではない。
ほとんどの場合、モジュールは、変数、関数、クラスなどの定義をするために使われる。
定義は1回だけすればよいため、モジュールを複数回インポートしても1回インポートしたのと同じ効果しかない。

モジュールをどうしてもリロード(再ロード)したいときには、importlibモジュールにあるreload関数を使う。
この関数に引数(リロードしたいモジュール)を1つ指定すると、リロードされたモジュールを返す。これは、モジュールを変更して、その変更を実行中のプログラムに反映させたいときに役に立つ。
```
import importlib
hello = importlib.reload(hello)
```


モジュールにおける関数定義
```python:hello2.py
# hello2.py
def hello():
    print("Hello world!")
```
hello2.pyをインポートするとモジュールとして実行され、hello関数はモジュールのスコープで定義される。
```
import hello2
hello2.hello()
```


モジュールへテストコードの追加
次のように書くと他のプログラムでhello関数を使おうとインポートした際にテストコードが実行される。
```python:listing10-03.py
# hello3.py
def hello():
    print("Hello world!")

# テスト
hello()
```

モジュールが単独でプログラムとして実行されているのか、他のプログラムにインポートされているのかを変数__name__を使ってチェックできる。
```python:1003__name__.py
import hello3
print __name__
print hello3.__name__
```

メインプログラム内では変数__name__の値は'__main__'になる。
インポートされたモジュール内では、そのモジュールの名前になる。

```python:hello4.py
def hello():
    print("Hello, world!")

def test():
    hello()

if __name__ == '__main__': test()
```

```python:1004__name__2.py
import hello4
hello4.hello()
```


モジュールを正しい場所に配置する  
ディレクトリのリストは、sysモジュールの変数pathで見ることができる。
モジュールを置くべき場所を確認する。
```
import sys,pprint
pprint.pprint(sys.path)
```
長すぎて1行に収まりきらないデータ構造体の場合は、pprintモジュールのpprint関数を使うとよい。pprintは「プリティプリント」をする関数。

ディレクトリsite-packagesは最良の選択肢。
hello4.pyをanother_hello.pyのように名前を変更してからsite-packagesへ保存する。
```
import another_hello
another_hello.hello()
```

モジュールをsite-packagesのような場所に置いてあれば、どのプログラムからでもインポートできるようになる。


インタプリタに探す場所を教える  
直接sys.pathを変更する方法は一般的な方法ではない。
環境変数PYTHONPATHにモジュールのディレクトリを指定する。  
bashで環境変数PYTHONPATHに~/pythonを追加するには次のようにする。
```
export PYTHONPATH=$PYTHONPATH:~/python
```


パッケージ  
複数のモジュールを構造化するには、まとめて「パッケージ」にする。
パッケージは基本的にはモジュールの一種。パッケージはディレクトリ。  
Pythonに対してパッケージとして扱わせるには、ディレクトリに__init__.pyという名前のファイルがなければならない。
パッケージを単なるモジュールのようにインポートすると、このファイルの内容がパッケージの内容になる。  
たとえば、constantsというパッケージがあり、さらにconstants/__init__.pyというファイルにPI = 3.14という文を記述している場合、次のようなことができる。
```
import constants
print(constants.PI)
```
モジュールをパッケージ内に入れるには、パッケージのディレクトリ内にモジュールのファイルを入れるだけ。また、パッケージを別のパッケージに入れて入れ子にすることもできる。  
たとえばdrawingというパッケージにshapesとcolorsというモジュールを含めるには、以下のようなファイルとディレクトリを用意する。

| ファイル/ディレクトリ | 説明 |
| --- | --- |
| ~/python/ | PYTHONPATHに入れるディレクトリ |
| ~/python/drawing | パッケージのディレクトリ(drawingパッケージ) |
| ~/python/drawing/__init__.py | パッケージのコード(drawingモジュール) |
| ~/python/drawing/colors.py | colorsモジュール |
| ~/python/drawing/shapes.py | shapesモジュール |

このように設定すれば、次の文はいずれも正しくなる。
```
import drawing
import drawing.colors
from drawing import shapes
```


モジュールの中身の探索  
モジュールについて探るいちばん直接的な方法はPythonインタプリタで調べること。
例えばcopyモジュールについて噂を聞いたとする。
```
import copy
```
例外が発生しないなら存在する。
モジュールの中身を見るのにdir関数が使える。
```
[n for n in dir(copy) if not n.startswith('_')]
```

__all__にはモジュール自体が設定しているリストが入っている。
これはモジュールの公開インタフェースを定義するもの。
このモジュールからすべての名前をインポートするということがどういうことかをインタプリタに伝える。
次のようにすると変数__all__にリストされていた3つの関数だけがインポートされる。
```
from copy import *
```

たとえばPyStringMapをインポートするには明示的にしなければならず、copyをインポートしておいてcopy.PyStringMapとするか、from copy import PyStringMapとする。
__all__を設定しておくことも、モジュールを書く際には有用な技法。モジュールには外部のプログラムが必要としない変数、関数、クラスなどがあるため、そういったものを除いておくのは礼儀にかなったことでもある。  
__all__を設定しないと、「*」でインポートされる名前のデフォルトはモジュール内の「_」で始まらないグローバル名すべてになる。


helpによるヘルプ  
通常必要とされる情報をすべて与えてくれる標準関数が1つある。
```
help(copy.copy)
```

表示されるヘルプテキストはcopy関数のドキュメンテーション文字列から抽出されたもの。
```
print(copy.copy.__doc__)
```


ドキュメント  
```
print(range.__doc__)
```
https://docs.python.org/library


ソースコード  
copyのソースコードを読みたいとする。
1つの方法はsys.pathを調べて自分で探すこと。
より速いのがモジュールのプロパティ__file__を調べること。
```
print(copy.__file__)
```


正規表現  
正規表現(regular expression。regexあるいはregexp)はテキストの一部にマッチさせることのできるパターン。

ワイルドカード  
1つの正規表現で2つ以上の文字列にマッチさせることができる。
「.」は改行を除くすべての1文字にマッチする。

特殊文字のエスケープ  
特殊文字を普通の文字と同じような振る舞いにするには「エスケープ」する。
文字の前に「\」(バックスラッシュ)を置く。
reモジュールは「\」を1つ要求するが、文字列内ではインタプリタからエスケープするために2個書く必要がある。

文字セット  
文字列を[...]内に入れることで「文字セット」を作ることができる。
文字セットは、中に含まれているすべての文字とマッチする。
例えば'[pj]ython'は'python'と'jython'の両方にマッチする。
文字範囲も使え、aからzまでの(アルファベットの)すべての文字にマッチさせるなら'[a-z]'とする。そのような文字範囲を続けて書いて組み合わせることもできる。
たとえば大文字、小文字、数字にマッチさせるなら'[a-zA-Z0-9]'とする(ただし、文字セットは1文字にしかマッチしない点に注意)。  
文字セットを反転させる(文字セットの補集合を指定する)場合は、先頭に「^」を置く。たとえば'[^abc]'とするとa、b、c以外の1文字にマッチする。

文字セット内の特殊文字  
「.」「*」「?」などの特殊文字をパターンの文字として使う場合「\」でエスケープする。
文字セットの内部では特殊文字のエスケープはたいてい不要。ただし、次のルールは頭に入れておく必要がある。
* 「^」(キャレット)は、文字列セットの先頭に置く場合、否定の演算子として機能させたいのでなければ、エスケープする必要がある。
* 「]」と「-」(ハイフン)は、文字列セットの最初に置くか、「\」でエスケープするかしなければならない(「-」は最後においても大丈夫ではある)。

選択肢とサブパターン  
文字列'python'と'perl'だけにマッチさせたい場合は、文字セットとワイルドカードでは作れない。
orを示す特殊文字「|」を使う。
具体的には'python|perl'で目的のパターンにマッチする。
しかし、「|」をパターン全体に使いたくないときには、サブパターンを(...)で囲む。
たとえば、'p(ython|erl)'と書いても上の例は目的を果たせる(「サブパターン」は1文字にマッチすることもできる)。

サブパターンのオプション指定や繰り返し  
サブパターンの後に「?」を付けると、そのサブパターンはなくてもよいことになる。マッチする文字列に現れてもよいが、必須ではない。
```
r'(https://)?(www\.)?python\.org'
```
このパターンは次の文字列のいずれにもマッチする(それ以外にはマッチしない)。
```
'https://www.python.org'
'https://python.org'
'www.python.org'
'python.org'
```
次の点に留意する。
* 「.」をエスケープしてワイルドカードとしての機能を止めている
* 「\」の数を減らすため、raw文字列を使っている
* オプションのサブパターンが(...)で囲まれている
* オプションのサブパターン2つはどちらも出現してもしなくてもよい。また、相互に依存関係はない(片方だけが出現しても、両方出現してもよい)。

「?」はサブパターンが1回現れるかまったく現れないことを表す。サブパターンが2回以上現れることを許す演算子がこの他に3つある。

* (pattern)* : patternはまったく出現しないか、1回以上繰り返される
* (pattern)+ : patternは1回以上繰り返される
* (pattern){m, n} : patternはm回以上n回以下繰り返される

文字列の先頭と末尾  
部分文字列の位置を文字列全体の先頭か末尾に固定したほうがよいことがある。
たとえば、文字列の先頭にある'ht+p'だけにマッチして、それ以外の場所ではマッチさせたくない場合など。そのような時は先頭を表す印として「^」(キャレット)を使う。
たとえば'^ht+p'は'http://python.org'にマッチする(もちろん'htttttp://python.org'にもマッチする)が、'www.http.org'にはマッチしない。同様に文字列の末尾は「$」で表す。


reモジュールの内容  
re.split関数  
文字列をパターンの出現位置で区切る。
```
some_text = 'alpha, beta,,,,gammma    delta'
re.split('[, ]+', some_text)
```

引数maxsplitは分割の最大数を指定する。
```
re.split('[, ]+', some_text, maxsplit=2)
re.split('[, ]+', some_text, maxsplit=1)
```

re.findall関数は与えられたパターンに一致したすべての部分のリストを返す。
```
pat = '[a-zA-Z]'
text = '"Hm... Err -- are you sure?" he said, sounding insecure.'
re.findall(pat, text)
```

句読点を見つけることもできる。
```
pat = r'[.?\-",]+'
re.findall(pat, text)
```

re.sub関数は一番左のオーバーラップなしのマッチを、与えられた代替文字列と置換する。
```
pat = '{name}'
text = 'Dear {name}...'
re.sub(pat, 'Mr.Gumby', text)
```

re.escape関数
正規表現の演算子として解釈される可能性のあるすべての文字をエスケープするのに使われるユーティリティ関数。
これを使うのは、特殊文字がたくさん入った長い文字列があって「\」を何度も入力しなければならないのを避けたい場合や、ユーザーから文字列を受け取り、それを正規表現の一部として使いたい場合など。
```
re.escape('www.python.org')
re.escape('But where is the ambiguity?')
```


マッチオブジェクトとマッチグループ  
reに属する関数のうち、文字列内の各部分にパターンが一致するかどうかを試す関数はすべて、マッチが見つかるとMatchObjectのオブジェクト(マッチオブジェクト)を返す。
このオブジェクトにはパターンにマッチした部分文字列の情報が入っている。
また、パターンのどの部分が部分文字列のどの部分にマッチしたのかという情報も入っている。
そういった各部分を「グループ」と呼ぶ。  
グループとは、単にサブパターンを括弧に入れたもの。
グループは「(」の出現順に従って番号が付けられる。
グループ0はパターン全体。
```
'There (was a (wee) (cooper)) who (lived in Fyfe)'
```
このパターンのグループは次のようになる。
```
0 There was a wee cooper who lived in Fyfe
1 was a wee cooper
2 wee
3 cooper
4 lived in Fyfe
```
通常、グループにはワイルドカードや反復演算子が含まれているため、あるグループがどんな文字列にマッチしたのかは簡単にはわからない場合がある。
```
r'www\.(.+)\.com$'
```
グループ0は文字列全体で、グループ1には'www.'と'.com'の間のすべての文字が入る。
このようにパターンを組み立てることで、文字列の中の知りたい部分を抽出することができる。
groupメソッドはパターン内の指定されたグループにマッチした(部分)文字列を返す。
グループ番号が渡されなければグループ0が仮定される。グループ番号を1つだけ指定すると(あるいはデフォルトの0を使うと)、単独の文字列が返される。
その他の場合は、与えられたグループ番号に対応する文字列のタプルが返される。
文字列全体(グループ0)の他に、99グループしか作れない。グループ番号の範囲は1から99になる。

```
m = re.match(r'www\.(.*)\..{3}', 'www.python.org')
m.group(1)
m.start(1)
m.end(1)
m.span(1)
```


置換文字列内のグループ番号と関数  
置換文字列内に'\n'を書くと、パターン内のn番目のグループの文字列に置換される。
'\*something\*'という形式の文字列を'<em>something</em>'という形式に置き換えたいとする。
```
emphasis_pattern = r'\*([^\*]+)\*'
```
作成する正規表現を読みやすくする方法の1つが、reの関数を呼び出す際にVERBOSEフラグを指定すること。パターンに空白文字(スペース、タブ、改行など)を加えることができ、reはそれらを(文字クラスに入れた場合と「\」でエスケープした場合を除いて)無視してくれる。
その場合には正規表現にコメントも入れることができる。
```
emphasis_pattern = re.compile(r'''
\*               # 強調タグの開始 -- 「*」1個
(                # キャプチャのためのグループ開始
[^\*]+           # 「*」を除くすべての文字をキャプチャ
)                # グループ終了
\*               # 強調タグの終了
            ''', re.VERBOSE)

re.sub(emphasis_pattern, r'<em>\1</em>', 'Hello, *world*!')
```

貪欲(greedy)か非貪欲(nongreedy)か  
反復演算子はデフォルトでは可能な限り長い文字列にマッチしようとする。
これを「貪欲(greedy)マッチ」「欲張りマッチ」「最長マッチ」などと呼ぶ。
```
emphasis_pattern = r'\*(.+)\*'
re.sub(emphasis_pattern, r'<em>\1</em>', '*This* is *it*!')
```
このパターンは最初の「\*」から最後の「\*」までのすべてにマッチしてしまう。
強調を表すのに'\*\*something\*\*'という形式を使っていたらどうなるか。
反復演算子の非貪欲バージョンを使えばよい。すべての反復演算子はその後に疑問符を置くことで非貪欲にできる。
```
emphasis_pattern = r'\*\*(.+?)\*\*'
re.sub(emphasis_pattern, r'<em>\1</em>', '**This** is **it**!')
```
演算子+の代わりに+?を使った。
パターンがワイルドカード1つ以上にマッチする点は同じだが、非貪欲となっているためできるだけ短いほうにマッチする。


ファイルのクローズ  
```
# ここでファイルを開く
try:
    # ファイルにデータを書き出す
finally:
    file.close()
```

with文で対応できる。
```
with open("somefile.txt") as somefile:
    do_something(somefile)
```
with文はファイルをオープンし、変数somefileに代入する。
with文の本体内でファイルにデータを書き込むと、その文の終わりに達した段階でファイルが自動的にクローズされる。


コンテキストマネージャー  
with文により「コンテキストマネージャー」を使うことができる。
コンテキストマネージャとは、__enter__と__exit__の2つのメソッドをサポートしているオブジェクト。  
__enter__メソッドは引数を取らない。このメソッドはwith文に入った段階で呼び出され、戻り値はキーワードasに続く変数にバインドされる。  
__exit__メソッドは3つの引数(例外タイプ、例外オブジェクト、例外トレースバック)を取る。
このメソッドはwith文を抜け出した時点で呼び出される(発生した例外は引数として渡される)。
__exit__が偽(False)を返すと、すべての例外が抑制される。  
ファイルはコンテキストマネージャーとして利用できる。
ファイルオブジェクトの__enter__メソッドは自分自身を返し、__exit__メソッドはファイルをクローズする。


単純なデータベースアプリケーション  
米国農務省(USDA)農業調査局(Agricultural Research Service, https://www.ars.usda.gov)のデータを基にした小規模な栄養素データベースの構築方法を確認する。
https://data.nal.usda.gov/dataset/composition-foods-raw-processed-prepared-usda-national-nutrient-database-standard-referen-10
から「sr28abbr.zip」をダウンロードする。


Requests
```
pip install requests
```


Twisted  
```
pip install twisted
```


Tidy  
Tidyライブラリには複数のPython用ラッパーがある。
どれが最新かは時期によって異なる。
候補を探すには以下のコマンドを実行。
```
pip search tidy
```
PyTidyLibをインストールする場合。
```
pip install pytidylib
```
ライブラリのラッパーをインストールしなければならないわけではない。
UNIXやLinuxの系統のOSなら、コマンドライン版のTidyが利用できる可能性が高い。
Tidyのサイト(http://html-tidy.org)から実行可能なバイナリを取得することも可能。
バイナリ版が入手できれば、subprocessモジュール(あるいはPopen系の関数)を使ってTidyのプログラムを実行できる。  


Beautiful Soup
```
pip install beautifulsoup4
```


CGIによる動的Webページ  
Webサーバーの準備  
macOSを使っているなら、Apache Webサーバがインストールされている。
```
sudo apachectl start    # 起動
sudo apachectl stop     # 停止
```

http.serverモジュールを使えばWebサーバーをPythonから一時的に起動できる。
Python実行ファイルに-mを付ければモジュールをインポートして実行できる。モジュールに--cgiを追加すれば、作成されたサーバはCGIをサポートする。
サーバは実行されているディレクトリにあるファイルをWebに公開する。秘密にするべきものが何もない事を確認してから実行する。
```
python3 -m http.server --cgi
```

これで、ブラウザでhttp://127.0.0.1:8000あるいはhttp://localhost:8000を表示させると、サーバを実行しているディレクトリのリスティングが見えるはず。
サーバ側では、接続状況に関するメッセージが表示される。  
また、CGIプログラムもWebからアクセス可能な場所に置く必要がある。さらに、サーバがソースコードをそのままWebページとして表示したりしないように、CGIスクリプトであると特定できることが必要。
方法として2点ある。

* スクリプトをcgi-binという名前のサブディレクトリに入れる
* スクリプトファイルの拡張子を.cgiにする

http.serverモジュールのサーバを使っていれば、cgi-binサブディレクトリを使わなければいけない。


Webアプリケーションフレームワークの利用  
Flask
```
pip install flask
```

スクリプトの名前がpowers.pyであったとすれば、次のようにするとFlaskにスクリプトを実行させることができる(UNIX系のシェルを想定)。
```
export FLASK_APP=powers.py
flask run
```

ブラウザにURLを入力するとpowersから返された文字列が表示される。
関数にもっと詳細なパスを指定する場合は、route('/')ではなくroute('/power')とする。
関数はhttp://127.0.0.1:5000/powersで利用可能になる。
関数に引数を渡す場合、引数は'<...>'を使って指定する。たとえば'/powers/<n>'のようになる。
こうすると、スラッシュの後に付けたものがnという名前のキーワード引数として関数に渡される。
しかしそれでは文字列となってしまう。
route('/powers/<int:n>')とすることで変換が追加される。こうした後でFlaskをリスタートすると、
http://127.0.0.1:5000/powers/3
というURLへのアクセスに対して、1、2、4という出力が得られる。

その他のWebアプリケーションフレームワーク  
* Django        https://djangoproject.com
* TurboGears    https://turbogears.org
* web2py        http://web2py.com
* Grok          https://pypi.python.org/pypi/grok
* Zope2         https://pypi.python.org/pypi/Zope2
* Pyramid       https://trypyramid.com


### Webサービス

Webサービスは、コンピュータフレンドリーなWebページのようなもの。
ネットワークを介してプログラムが情報を交換できるような規格とプロトコルに基づいており、通常は一方のプログラム(クライアントあるいはサービスリクエスタと呼ばれる)が情報やサービスを求め、もう一方のプログラム(サーバあるいはサービスプロバイダ)がその情報やサービスを提供する。


## テストの基本とツール

「まずはテスト、コーディングは後」。これは「テスト駆動プログラミング(test-driven programming)」とも呼ばれる。  

### 正確な要求仕様

プログラムが満たさなければならない要件を記述した文書(あるいは簡単なメモ)、すなわち要求仕様を記述すれば、プログラムの目標を明確化できる。
そして、要件を実際に満たしているかどうかを後で確認することが容易になる。
要件(requirements)には、「顧客満足」といった、ややあいまいな概念を含め、多くの種類がある。ここでは、機能要件(functional requirements)、つまり、プログラムの機能に要求されることに焦点をあわせる。

Pythonで要件を指定し、それを満たしているかどうかをPythonインタプリタにチェックさせることができる。

簡単な例として、与えられた高さと幅の長方形の面積を計算する単独の関数からなるモジュールを書くとする。
コーディングを始める前に答えがわかっている例を使って単体テストを記述する。

```
from area import rect_area

height = 3
width = 4
correct_answer = 12
answer = rect_area(height, width)
if answer == correct_answer:
    print('テストに合格しました')
else:
    print('テストに不合格でした')
```

この例では、高さを3、幅を4として関数rect_area(まだ記述していない)を呼び出し、その関数の答えを正しい12と比較する。
もし、rect_area(ファイルarea.pyに記述)を不注意で次のように実装して、テストプログラムを実行してみるとエラーメッセージが表示される。
```
def rect_area(height, width):
    return height * height
```

そこでコードを見直し、誤りを見つけ、戻り値の数式をheight * widthで置き換える。
目的となるプログラムのコードを書く前にテストを記述するのは、コードが適正に動作することを確認するための準備。


### 変更に備える

自動テストは、プログラムを記述するときに大きな助けになることに加え、変更の際にエラーの累積を防ぐのに役立つ。
プログラムを(適切な抽象化とカプセル化を使って)上手に設計していけば、変更の影響は局所的でコードの小さな部分にしか及ばないはず。つまり、バグがどこにあるかを見つけられれば、デバッグは容易になる。


### コードカバレッジ

テストに関する知識の中でもカバレッジの概念は重要。
優れた一連のテストの目標の1つは、十分な範囲をカバーすることであり、そのための手段としてはカバレッジツールを利用する方法がある。
カバレッジツールは、コードのテスト時に実際に実行された部分の割合を計測する。
「test coverage python」といったキーワードでWeb検索するといくつか選択肢が見つかる。
1つはtrace.pyで、これはPythonの配布パッケージに付属している。
コマンドラインでプログラムとして実行することも(場合によっては、ファイルが見つからないのを防ぐため-mスイッチを指定)、モジュールとしてインポートすることもできる。


### テストの手順

テスト駆動開発の流れ(の一例)を確認する。

1. 目的とする機能を把握する。場合によっては文書化し、そのためのテストを記述する
2. その機能のスケルトンコードを記述する。ただし、プログラムは構文エラーなど発生せずに動作するが、テストは失敗するように記述する。テストの失敗を確認することが重要。実際に失敗してよい。テストに誤りがあり、どんな場合でも成功してしまうようではテストにならない。テストが失敗することを確認してから、テストを成功させようとする
3. 作成したスケルトンに、テストを通過させるためだけのダミーのコードを記述する。ここでは目的の機能を正確に実装する必要はなく、テストに合格させることだけが必要。こうすれば、開発期間中、初めて機能を実装している間も含めて、常にすべてのテストを成功させることができる(テストを初めて実行する時は別)
4. テストが成功することを常に確認しながら、コードを書き直して(または「リファクタリング」して)、実際に目的どおりに動作するようにする

コードの変更を一時停止する際には、必ず「健全な状態」にしておくべき。
テストで何らかの失敗がある(またはダミーコードでテストに合格する)状態で残してはいけない。


## テスト用ツール

テストを自動化する2つのモジュール。

* unittest  ：  汎用テストフレームワーク
* doctest   ：  ドキュメントのチェック用に設計された単純なモジュール。単体テストを記述するのにも優れている


### doctest

例として、数値を2乗する関数を記述し、そのdocstring(コードの冒頭にドキュメントを書くための文字列。ドキュメンテーション文字列とも呼ばれる)において関数の実行例と結果を記述する場合を考える。

```
def square(x):
    '''
    数値を2乗して結果を返す
    >>> square(2)
    4
    >>> square(3)
    9
    '''
    return x * x
```

square関数はmy_mathモジュール(my_math.py)の中で定義しているとする。
末尾に次の3行を追加する。
```
if __name__ == '__main__':
    import doctest, my_math
    doctest.testmod(my_math)
```

doctestとmy_mathモジュール自身をインポートして、doctestのtestmod関数(test moduleの意)を実行する。
```
python3 my_math.py
```

何も起きていないように見えるが、doctest.testmod関数はモジュールのdocstringをすべて読み込んで、対話型インタプリタで実行した例のように見えるテキストを探し出す。そしてその例が実際のものと一致するかを確認している。

詳しい出力を得るには、実行時に-vを指定する(-vはverbose[言葉数が多い]の意)。
```
python3 my_math.py -v
```

testmod関数は、my_mathモジュールのdocstring(こちらにはテストは含まず)とsquare関数のdocstring(2つのテストが含まれ、両方とも成功)の両方を調べる。
テストを残したまま、コードを変更できる。2乗を求めるのに*の代わりに累乗演算子を使って、x ** 2と書くことにしたとする。ところが、数字の2の代わりにxを書いてしまったとする(x ** x)。
テストスクリプトを実行するとどうなるか。
```
python3 my_math.py
```

バグが見つかるので、修正して再度実行する。
この例では、square(2)によるテストではこのバグは見つけられない。
x == 2の場合、x ** 2とx ** xは同じになる。


## unittest

doctestがとても簡単に使えるのに対して、unittestは、柔軟性に優れていて強力(Java用テストフレームワークのJUnitがベース)。unittestはdoctestよりも習得に時間がかかるが、大規模で包括的な一連のテストを体系だった方法で記述できる。

このほかの単体テストツールとしては、pytest(https://pytest.org/en/latest/)やnose(https://nose.readthedocs.io/en/latest/)などがある。

ここでも簡単な例を見る。  
積を計算するproduct関数を含むmy_math2というモジュールを記述する(ファイルtest_my_math2.py)。
unittestモジュールのTestCaseクラスを使う。
```
import unittest, my_math2

class ProductTestCase(unittest.TestCase):

    def test_integers(self):
        for x in range(-10, 10):
            for y in range(-10, 10):
                p = my_math2.product(x, y)
                self.assertEqual(p, x * y, 'Integerの乗算に失敗しました')
    
    def test_floats(self):
        for x in range(-10, 10):
            for y in range(-10, 10):
                x = x / 10
                y = y / 10
                p = my_math2.product(x, y)
                self.assertEqual(p, x * y, 'Floatの乗算に失敗しました')

if __name__ == '__main__': unittest.main()
```

unittest.main関数が、テスト実行の面倒をみてくれる。
これがTestCaseのすべてのサブクラスをインスタンス化し、名前がtestで始まるすべてのメソッドを実行する。

setUpとtearDown(tear downは「解体」などの意)というメソッドを定義すれば、各テストメソッドの前と後に実行される。これらのメソッドにより、すべてのテストに共通の初期化と後始末の処理、いわゆるテストフィクスチャ(test fixture)が行える。

このテストスクリプトを実行しても、my_math2モジュールがないために例外が発生する。
assertEqualなどのメソッドは条件を検査して所定のテストが成功した化失敗したかを判別する。
TestCaseクラスには他に、assertTrue、assertIsNotNone、assertAlmostEqualなど多くの似たメソッドがある。

my_math2モジュール(つまりmy_math2.pyというファイル)を書く。
unittestモジュールは、例外を発生させる「エラー(error)」と、failUnlessなどの呼び出しの結果である「失敗(failure)」とを区別する。my_math2を次のように記述すると、「失敗」が起こる。
```
def product(x, y):
    pass
```

テストを実行すると、2つのFAILメッセージが出力される。
テストが実際にコードに関連付けられている。
現在のコードは正しくなく、テストは失敗する。
次のステップは、コードが正しく機能するようにすること。
```
def product(x, y):
    return x * y
```

出力1行目の2つのドットはテストを表している。失敗の時はFと出力されている。
試しに、product関数を変更して、引数が7と9のときに失敗するようにする。
```
def product(x, y):
    if x == 7 and y == 9:
        return '潜んでいたバグが発覚！'
    else:
        return x * y
```

再度テストスクリプトを実行すると、発生する失敗は1つだけ。

オブジェクト指向のコードの高度なテストについては、unittest.mockモジュールを参照。


## 単体テストを超えて

プログラムの検査には他の方法もある。
ソースコード検査(source code checking)とプロファイリング(profiling)。
ソースコード検査はコードによくある誤りや問題点を見つける方法(性的型付け言語でコンパイラが行うことに少し似ているが、それをはるかに超える検査)。プロファイリングはプログラムの実際の速度を知る方法。
単体テストは動作させることに役立ち、ソースコード検査は質を高め、プロファイリングは高速化に役立つ。


### ソースコードの検査 - PyCheckerとPyLintの活用

かなり長い間、PyChecker(http://pychecker.sourceforge.net)が、Pythonのソースコードを検査し、関数に合わない引数を渡しているなどの誤りを検出する唯一のツールだった。
その後、PyLint(https://pylint.org)が登場した。これはPyCheckerのほとんどの機能に加えて、さらに多くの機能を揃えている(変数名が指定の命名規則に従っているか、コードが指定の基準を守っているかなどの検査)。
これらのツールのインストールは簡単。PyLintはpipでもインストールできる。
```
pip install pylint
```

どちらも(Debian APT、Gentoo Portageなど)複数のパッケージマネージャシステムから入手できる。
それぞれのサイトから直接ダウンロードしても構わない。
Distutilsを使って、次のように標準コマンドでインストールする。
```
python setup.py install
```

インストールできたら、PyCheckerとPyLintはコマンドラインスクリプトとしても(名前はそれぞれpycheckerとpylint)、Pythonモジュールとしても使うことができる(名前は同じ)。

Windowsの場合、これら2つはコマンドラインでバッチファイルpycheker.bat、pylint.batを使う。
コマンドラインでpychecker、pylintのコマンドを使えるようにするには、環境変数PATHの設定が必要な場合がある。

PyChekcerでファイルを検査するには、次のようにファイル名を引数としてスクリプトを実行する。
```
pychecker file1.py file2.py ...
```

PyLintの場合は、モジュール(またはパッケージ)の名前を使う。
```
pylint module
```

これらの検査プログラムを単体テストと組み合わせる方法を見ておく。
一連のテストの1つとして、両方(または片方)を自動実行させ、問題がなければ何事もなくテストが終わるようにするのが楽。そうすれば、一連のテストで機能だけでなくコードの品質も検査できる。

PyCheckerとPyLintは、モジュール(pychecker.checker、pylint.lint)としてインポートできる。
しかし、実際にプログラムで読み込んで使うようには設計されていない。
pychecker.checkerをインポートすると、それ以降のコードを(インポートしたモジュールを含め)検査し、警告を標準出力に出力する。pylint.lintモジュールには文書化されていないRunという関数があり、これがpylintスクリプト自体の中で使われる。こちらも警告を何らかの方法で返すのではなく表示する。
PyCheckerとPyLintは想定されている通りの使い方、つまりコマンドラインで使うことが推奨される。
Pythonでコマンドラインツールを使う方法は、subprocessモジュールを使うこと。

以前のテストスクリプトの例に対して、コード検査のテストを2つ加えたものを示す(my_math3というモジュール名に変更)。

```
import unittest, my_math3
from subprocess import Popen, PIPE

class ProductTestCase(unittest.TestCase):

    def test_integers(self):
        for x in range(-10, 10):
            for y in range(-10, 10):
                p = my_math3.product(x, y)
                self.assertEqual(p, x * y, 'Integerの乗算に失敗しました')
    
    def test_floats(self):
        for x in range(-10, 10):
            for y in range(-10, 10):
                x = x / 10
                y = y / 10
                p = my_math3.product(x, y)
                self.assertEqual(p, x * y, 'Floatの乗算に失敗しました')

    def test_with_PyChecker(self):
        cmd = 'pychecker', '-Q', my_math3.__file__.rstrip('c')
        pychecker = Popen(cmd, stdout=PIPE, stderr=PIPE)
        self.assertEqual(pychecker.stdout.read(), '')
    
    def test_with_PyLint(self):
        cmd = 'pylint', '-rn', 'my_math3'
        pylint = Popen(cmd, stdout=PIPE, stderr=PIPE)
        self.assertEqual(pylint.stdout.read(), '')

if __name__ == '__main__': unittest.main()
```

検査プログラムにコマンドラインスイッチを指定して、テストの邪魔になる本質的でない出力を防ぐ。
pycheckerには、-Q(Quiet:「出力しない」)スイッチを指定している。
pylintには、レポートをオフにする-rn(nは「ノー」を表す)を指定して、警告とエラーだけを出力するようにしている。

コマンドpylintは、与えられたモジュール名をそのまま使って動作するので簡単。
pycheckerを正しく動作させるには、ファイル名を取得する必要がある。そのためにmy_math3モジュールの__file__プロパティを使い、さらに、ファイル名の末尾にあるかもしれないcをrstripで取り除いている(モジュールが実際には.pycファイルであるかもしれないため)。

PyLintの出力を抑えるため、(短い変数名、リビジョン、docstringがない、などの場合に出力をしないように設定するのではなく)my_math2モジュールを少し書き直し、そのファイル名をmy_math3.pyとしている。
```
"""
単純な数学モジュール
"""
__revision__ = '0.1'

def product(factor1, factor2):
    '2つの数の積'
    return factor1 * factor2
```

今度はテストを実行しても、エラーは発生しないはず。
コードをいじってみて、チェッカーがエラーを出力しても機能テストがうまくいくことを確認する(PyCheckerとPyLintを外してもかまわない。おそらく片方を外せば動作する)。
たとえば、仮引数の名前をxとyに戻してみると、PyLintは変数名が短いことを警告するはず。
あるいは、return文の後にprint('Hello, world!')を追加すると、きわめて正当に両方のプログラムが警告する(警告の理由は異なるかもしれない)。


### プロファイリング

要件に照らして十分に速くなく、本当にプログラムの最適化が必要であれば、プロファイルを取ることが必要。
これは、プログラムが余程単純なものでなければ、ボトルネックとなっている場所を推定することが難しいため。
そして、何がプログラムの速度を落としているのかを知らなければ、最適化の対象を誤ってしまう。

標準ライブラリには、profileという優れたプロファイラモジュールと、cProfileというCで作成された高速版がある。プロファイラのrunメソッドを呼び出して文字列引数を渡すだけで使える。
```
import cProfile
from my_math3 import product
cProfile.run('product(1, 2)')
```

これで、それぞれの関数とメソッドの呼び出し回数と消費時間が出力表示される。
ファイル名(例'my_math3.profile')を第2引数に指定して実行すると、結果がファイルに保存される。後でpstatsモジュールを使ってプロファイルを調べることができる。
```
import pstats
p = pstats.Stats('my_math3.profile')
```

このStatsオブジェクトを使うと、結果をプログラムで調べることができる。

標準ライブラリにはtimeitというモジュールもあり、Pythonの小さなコードの実行時間を簡単に測定できる。
timeitモジュールは詳細なプロファイリングにはあまり役に立たないが、一片のコードの実行にどれだけ時間がかかるのかを知るには便利なツール。

## JythonとIronPython

Jython(https://jython.org)かIronPython(https://ironpython.net)を使っている場合、Pythonをネイティブモジュールで拡張するのは簡単。土台となっている言語(JythonではJava、IronPythonではC#および他の.NET言語)から直接、モジュールとクラスにアクセスできる一方で、(CPythonを拡張する場合にしなければならないように)特定のAPIに合わせる必要がない。必要な機能を実装するだけでPythonで使うことができる。
代表的な例として、JythonではJava標準ライブラリを直接使用でき、IronPythonではC#標準ライブラリを直接利用できる。
簡単なJavaクラスを示す。
```Java:JythonTest.java
public class JythonTest {
    public void greeting() {
        System.out.println("Hello, world!");
    }
}
```

これは、javacなどのJavaコンパイラでコンパイルできる。
```
javac JythonTest.java
```

そのクラスをコンパイルしたら、Jythonを起動する(そして、できた.classファイルをカレントディレクトリあるいはJavaの環境変数CLASSPATHに設定してある場所のどこかに置く)。
```
CLASSPATH=JythonTest.class jython
```

するとそのクラスを直接、インポートできる。
```
import JythonTest
test = JythonTest()
test.greeting()
```

Jythonでは、JavaBeansプロパティにアクセスできる。

同様なC#クラスを示す。
```C#:IronPythonTest.cs
using System;
namespace FePyTest {
    public class IronPythonTest {
        public void greeting() {
            Console.WriteLine("Hello, world!");
        }
    }
}
```

これをコンパイルする。
```
csc.exe /t:library IronPythonTest.cs
```

IronPythonでこれを使う1つの方法は、このクラスをコンパイルしてダイナミックリンクライブラリ(DLL)を作成し、関係する環境変数(PATHなど)を必要に応じて設定すること。そうすれば、次のように(IronPythonの対話型インタプリタで)使える。
```
import clr
clr.AddReferenceToFile("IronPythonTest.dll")
import FePyTest
f = FePyTest.IronPythonTest()
f.greeting()
```


## C拡張モジュールの記述

Pythonの拡張とは通常、CPythonの拡張を意味する。
CPythonはCで実装された標準のPython。
Python用にC拡張モジュールを記述する場合、厳密なAPIに従う必要がある。
C拡張モジュールを簡単に記述できるようにするプロジェクトとして、SWIGがある。
その他のアプローチとしては以下の通り。

* Cython(https://cython.org)
* PyPy(https://pypy.org)
* Weave(https://scipy.org)
* NumPy(https://numpy.org)
* ctypes(https://docs.python.org/ja/3/library/ctypes.html)
* subprocess(https://docs.python.org/ja/3/library/subprocess.html)
* PyCXX(https://cxx.sourceforge.net)
* SIP(https://www.riverbankcomputing.co.uk/software/sip)
* Boost.Python(https://www.boost.org/libs/python/doc)


### SWIG - C/C++コードのラップツール

SWIG(https://www.swig.org。Simple Wrapper and Interface Generatorの略)は、複数の言語で利用できるツール。拡張モジュールのコードをCやC++で記述できるが、それをTcl、Python、Perl、Ruby、Javaなどの言語の中で使えるように自動的にラップしてくれる。
開発対象のシステムの一部をC拡張モジュールで記述すれば、他の複数の言語でも利用できる。
複数の言語でサブシステムを記述して組み合わせたい場合に特に便利。
C(またはC++)で記述した拡張モジュールにハブの役割を担わせることができる。
SWIGのインストールは他のPythonツールの場合と同じ。

* SWIGはhttp://www.swig.orgで入手可能
* 多くのUNIX/LinuxディストリビューションにはSWIGが付属している。多くのパッケージマネージャーが対応していて、SWIGを直接インストールできる。
* Windows用にはバイナリインストーラがある。
* ソースファイルから自分でコンパイルする場合も、configureとmake installを実行するだけでよい


### SWIGで生成されるファイル

1. 開発者は、用意したコードのためのインタフェースファイルを記述する(Cのヘッダファイルによく似たもの。単純な場合は、ヘッダファイルをそのまま利用可能)
2. インタフェースファイルに対してSWIGを実行すると、追加のCのコード(ラッパーコード)が自動生成される
3. 元のCのコードと生成したラッパーコードとをコンパイルして共有ライブラリを生成する


### 回文の処理

回文とは「I Prefer Pi」のように、空白や句読点、大文字小文字の区別を無視すれば後ろから読んでも同じになる文のこと。
タンパク質の配列解析など長大な回文構造を判別したいと仮定する(空白などの違いも許さないとする)。
それをCで書く。
```C:palindrome.c
#include <string.h>

int is_palindrome(char *text) {
    int i, n=strlen(text);
    for (i = 0; i <= n/2; ++i) {
        if (text[i] != text[n-i-1]) return 0;
    }
    return 1;
}
```

参考までに、純粋なPythonによる同等の関数を示す。
```Python:palindrome_in_python.py
def is_palindrome(text):
    n = len(text)
    for i in range(len(text) // 2):
        if text[i] != text[n-i-1]:
            return False
    return True
```


### インタフェースファイル

palindrome.cを作成したら、次はpalindrome.iというファイルにインタフェースを記述する。
多くの場合、ヘッダファイル(palindrome.h)を定義すれば、SWIGはそこから必要な情報を得られる。
したがって、ヘッダがあるならば、それを使うことを試したほうがよい。
ただし、明示的にインタフェースファイルを記述すれば、SWIGによるコードのラップ方法を微調整できる。
特に、何か除外したい時にこの手法を用いることが多い。
たとえば、大きなCのライブラリをラップするけれども、Pythonにエクスポートしたいのは数個の関数だけというような場合、エクスポートしたい関数だけをインタフェースファイルに記述する。

インタフェースファイルでは、単にエクスポートしたいすべての関数(と変数)をヘッダファイルと同じように宣言する。
また、その前にインクルードするヘッダファイル(今回はstring.h)を指定するため、%{と%}で区切った部分を記述する。さらにその前で%module宣言にモジュール名を指定する(これらの一部はオプション。また、インタフェースファイルにはこの他の機能もある)。
```インタフェースファイル:palindrome.i
%module palindrome

%{
#include <string.h>
%}

extern int is_palindrome(char *text);
```


### SWIGの実行

インタフェースファイル(または、必要に応じてヘッダファイル)を指定して、SWIGを実行する。
```
swig -python palindrome.i
```

この後、新しいファイルが2つできる。
palindrome_wrap.cとpalindrome.py。


### コンパイル、リンク、実行

コンパイルを正しく行うには、使っているPythonのディストリビューションのソースコード(あるいはpyconfig.hとPython.hというヘッダファイル)の場所を指定する必要がある(ソースコードやヘッダファイルは、インストールされているPythonのルートディレクトリやIncludeサブディレクトリにあるかもしれない)。
また、使用中のCコンパイラでコードをコンパイルして共有ライブラリにするための適切なスイッチも知っておく必要がある。
Linuxでgccを使う場合のコマンドは以下の通り。
$PYTHON_HOMEがPythonのインストール先ルートディレクトリを指しているとする。
```
gcc -c palindrome.c
gcc -I$PYTHON_HOME -I$PYTHON_HOME/Include -c palindrome_wrap.c
gcc -shared palindrome.o palindrome_wrap.o -o _palindrome.so
```

Solarisでccを使う例。
```
cc -c palindrome.c
cc -I$PYTHON_HOME -I$PYTHON_HOME/Include -c palindrome_wrap.c
cc -G palindrome.o palindrome_wrap.o -o _palindrome.so
```

Solarisでgccを使う場合、コマンドラインの最初の2行にはフラグ-fPICを(コマンドgccのすぐ右に)追加する。

Windowsの場合(これもコマンドラインでgccを使うとして)、共有ライブラリを作成するには、最後の行に次のようなコマンドを使う。
```
gcc -shared palindrome.o palindrome_wrap.o C:/Python37/libs/libpython37.a -o _palindrome.dll
```

macOSでは、次のようなコマンドになる(公式のPythonでインストールする場合、PYTHON_HOMEは/Library/Frameworks/Python.framework/Versions/Current)。
```
gcc -dynamic -I$PYTHON_HOME/include/python3.7 -c palindrome.c
gcc -dynamic -I$PYTHON_HOME/include/python3.7 -c palindrome_wrap.c
gcc -dynamiclib palindrome_wrap.o palindrome.o -o _palindrome.so -Wl,-undefined dynamic_lookup
```


_palindrome.soというファイルができる。
これが目的とするファイルで、カレントディレクトリなどPYTHONPATHに設定してある場所に配置すれば、次のように直接、Pythonにインポートできる。
```
import _palindrome
dir(_palindrome)
_palindrome.is_palindrome('ipreferpi')
_palindrome.is_palindrome('notlob')
```

SWIGの旧バージョンはこれで終わりだったが、その後のバージョンはPythonのラッパーコードも生成する(palindrome.py)。このラッパーコードは_palindromeモジュールをインポートし、検査も少々行う。
それを省きたい場合は、palindrome.pyを削除することで、開発者自身のライブラリを直接、palindrome.soというファイルにリンクすることもできる。
このラッパーコードを使うと、共有ライブラリを使った場合と同じようにできる。
```
import palindrome
from palindrome import is_palindrome
if is_palindrome('abba'):
    print('Wow -- that never occurred to me ...')

```


### コンパイラの魔法の森を抜ける

Setuptoolsを使えば、直接SWIGに対応しているため手動で実行する必要がない。
コードとインタフェースファイルを記述してセットアップスクリプトを実行するだけでよい。


### 拡張モジュール向けのフレームワーク

定型コードは自動生成できるが、手作業でやってみるのも勉強になる。
ヘッダファイルPython.hを他の標準ヘッダよりも前にインクルードしなければならない。
これは、一部のプラットフォームで他のヘッダで使われるものを再定義する場合があるから。
```
#include <Python.h>
```

作成する関数の名前は何でもかまわない。
関数はstaticで、PyObject型オブジェクトへのポインタ(所有参照)を返し、2つの引数(いずれもPyObjectへのポインタ)をとる必要がある。
これらのオブジェクトの名前には慣例としてselfとargsが使われる(selfは自己のオブジェクトまたはNULL、argsは引数のタプル)。関数は次のようになる。
```
static PyObject *somename(PyObject *self, PyObject *args) {
    PyObject *result;
    /* resultへの割当などの処理をここに記述 */
    Py_INCREF(result);  /* 必要な場合のみ */
    return result;
}
```

引数selfは実際にはオブジェクトに結び付けられたメソッドでのみ使われる。
他の関数ではただのNULLポインタになる。
Py_INCREFの呼び出しは不要な場合がある。このオブジェクトは関数内で(たとえば、ユーティリティ関数Py_BuildValueなどを使って)生成され、関数はすでにそれへの参照を保持しているので、それを返すだけで済む。
しかし関数からNoneを返したい場合は、用意されているPy_Noneオブジェクトを使うべき。
ただしその場合、その関数はPy_Noneへの参照を保持していないので、Py_INCREF(Py_None)を呼び出してから返す必要がある。
仮引数argsは、作成するこの関数への引数のすべて(実引数selfがある場合はそれを除く)を含んでいる。オブジェクトを取り出すには、PyArg_ParseTuple関数(位置指定引数用)とPyArg_ParseTupleAndKeywords(位置指定引数とキーワード引数用)を使う。今回は、位置指定引数のみを使う。
PyArg_ParseTupleのシグネチャは次のとおり。
```
int PyArg_ParseTuple(PyObject *args, char *format, ...);
```

文字列formatは想定している引数を指定するもので、値を入れる変数のアドレスを最後に指定する。
戻り値はブール値。
これがTrueならすべて正常で、Falseならエラー発生を示す。
エラーがあった場合、例外を生成するようになっているので、コードで記述するのは処理を取り消すためにNULLを返すことだけ。
したがって、引数を受け取らない場合(フォーマット文字列は空)、引数の指定方法は次のようにする。
```
if (!PyArg_ParseTuple(args, "")) {
    return NULL;
}
```

この文よりも先に進んだら、引数の取得が済んだということ(この例では引数なし)。
フォーマット文字列は、文字列を"s"、整数を"i"、Pythonオブジェクトを"o"で表し、たとえば、整数2つと文字列1つならば"iis"になる。
フォーマット文字列コードには他にも種類がある。
必要な関数ができても、そのCのコードをモジュールとして使えるようにするには、さらにラップする必要がある。


### 回文処理の完成形

palindromeモジュールのPython C API版を示す。
```C:palindrome2.c
#include <string.h>

static PyObject *is_palindrome(PyObject *self, PyObject *args) {
    int i, n;
    const char *text;
    int result;
    /* "s" は単一の文字列を意味する */
    if (!PyArg_ParseTuple(args, "s", &text)) {
        return NULL;
    }
    /* 以前のコードと基本的に同じ */
    n = strlen(text);
    result = 1;
    for (i = 0; i <= n/2; ++i) {
        if (text[i] != text[n-i-1]) {
            result = 0;
            break;
        }
    }
    /* "i"は単一の整数を意味する */
    return Py_BuildValue("i", result);
}

/* メソッド/関数のリスト */
static PyMethodDef PalindromeMethods[] = {
    /* 名前、関数、引数の型、docstring */
    { "is_palindrome", is_palindrome, METH_VARARGS, "Detect palindromes" },
    /* リストの終わりの目印 */
    { NULL, NULL, 0, NULL }
};

static struct PyModuleDef palindrome =
{
    PyModuleDef_HEAD_INIT,
    "palindrome",   /* モジュール名 */
    "",             /* docstring(ドキュメンテーション文字列) */
    -1,             /* 大域変数に保持されるシグナルの状態 */
    PalindromeMethods
};

/* モジュールの初期化関数 */
PyMODINIT_FUNC PyInit_palindrome(void)
{
    return PyModule_Create(&palindrome);
}
```

追加したコードの大部分は定型パターン。
palindromeとなっているところに、作成するモジュールの名前を入れる。
is_palindromeとなっているところには、関数名を入れる。
他にも関数がある場合は、単純にそれらをすべて配列PyMethodDefに列挙する。
注意点は、初期化関数の名前がinitmoduleで「module」の部分は作成するモジュールの名前でなければならない。
違っていると、Pythonがそれを見つけられなくなる。
gccを使ってコンパイルする例。
```
gcc -I$PYTHON_HOME -I$PYTHON_HOME/Include -shared palindrome2.c -o palindrome.so
```

これでpalindrome.soというファイルが生成され、使えるようになっているはず。
PYTHONPATHに設定してある場所に配置して試す。
```
from palindrome import is_palindrome
is_palindrome('foobar')
is_palindrome('deified')
```


## Setuptoolsの基本

Python Packaging User Guide (https://packaging.python.org)とSetuptoolsサイト(https://setuptools.readthedocs.io)に多くの関連文書がある。
Setuptools(pipでインストール可能)を使うと、次のような簡単なスクリプトを記述することで、いろいろと有用なことができる。
```
from setuptools imoprt setup

setup(name='Hello',
      version='1.0',
      description='簡単な例',
      author='Magnus Lie Hetland',
      py_modules=['hello'])
```

このスクリプトをsetup.pyという名前で保存し(これはDistutilsのセットアップスクリプトの全般的な規約)、hello.pyというモジュールを同じディレクトリに置く。

このセットアップスクリプトは、カレントディレクトリに新しくファイルとサブディレクトリを作成する。
古いファイルがあると上書きされてしまう。
試すなら新規のディレクトリの中で行うのがよい。

このスクリプトの使い方を見ていく。
次のように実行する。
```
python setup.py
```

ヘルプが表示される。
buildコマンドを指定して動きを見てみる。
```
python setup.py build
```

Setuptoolsがbuildというディレクトリとlibというサブディレクトリを作成し、hello.pyをbuild/libにコピーしている。buildサブディレクトリは、Setuptoolsがパッケージを組み立てる(拡張モジュールライブラリのコンパイルなどを行う)一種の作業領域。
実際にはインストール時にbuildコマンドを実行する必要はない。
installコマンドの実行時に必要に応じて自動的に実行される。

インストールの過程でSetuptoolsは、ファイルをまとめてegg(自己完結したパッケージ)を作成している。


### 配布物などのアーカイブ

アーカイブファイルの作成方法。
Windowsインストーラーや、RPMパッケージ、eggディストリビューション、wheelディストリビューション、その他も作成できる(Wheelは最終的にeggに取って代わることを目的としている)。
.tar.gzの例から順を追って確認する。
ソースアーカイブファイルはsdistコマンド(source distributionの意)で作成する。
```
python setup.py sdist
```
これを実行すると、いくつかの警告を含むかなりの量の出力が表示される。
buildと別にdistというサブディレクトリができ、その中にHello-1.0.tar.gzというgzip圧縮されたtarアーカイブができる。
このアーカイブはユーザーに配布でき、ユーザーはこのファイルを展開し、中に含まれているsetup.pyを実行することでインストールが行える。
.tar.gz以外の配布用形式を使う場合は、--formatsオプションで指定する。複数の形式をカンマ区切りで指定すれば一度に複数の形式のアーカイブファイルを作成できる。
sdist --help-formatsを指定すれば形式は確認できる。


### 拡張モジュールのコンパイル

拡張モジュールのコンパイルにもSetuptoolsが使える。
空のカレントディレクトリにソースファイルpalindrome2.cがある場合、次のsetup.pyでコンパイル(とインストール)が行える。
```Python:setup.py
from setuptools import setup, Extension

setup(name='palindrome',
      version='1.0',
      ext_modules = [
        Extension('palindrome', ['palindrome2.c'])
      ])
```

このsetup.pyを指定してinstallコマンドを実行すると、palindrome拡張モジュールがインストール前に自動的にコンパイルされる。
モジュール名のリストを指定する代わりに、引数ext_modulesを使ってExtensionインスタンスのリストを指定する。
このコンストラクタは名前と、関係するファイルのリストとを受けとる。
ヘッダファイル(.h)などもここに指定する。
拡張モジュールをコンパイルして、その同じ場所においておきたい場合は(ほとんどのUNIXシステムではpalindrome.soというファイルがカレントディレクトリにできる)、次のコマンドが使える。
```
python3 setup.py build_ext --inplace
```
SWIGをインストール済みであれば、Setuptoolsに直接それを使わせることができる。
SetuptoolsにSWIGを使わせて、Python拡張モジュールとして直接コンパイルが可能。
Extensionインスタンスのファイルのリストにインタフェース(.i)ファイルの名前を追加するだけ。
```
from setuptools import setup, Extension

setup(name='palindrome',
      version='1.0',
      ext_modules = [
        Extension('_palindrome', ['palindrome.c', 'palindrome.i'])
      ])
```

このスクリプトを前回と同じコマンドで(build_extで、必要なら--inplaceスイッチを付けて)実行すると、.soファイル(または同等のファイル)ができる。
今回は自分でラッパーコードを記述する必要がない。
拡張モジュールの名前を_palindromeにしていることに注意。
これはSWIGがpalindrome.pyという名前でラッパーを生成し、ラッパーがCのライブラリをこの名前(_palindrome)でインポートするため。


### py2exeによる実行可能プログラムの作成

Setuptoolsのpy2exe拡張モジュール(pipで入手可能)を使うと、実行可能なWindowsプログラム(.exeファイル)をビルドできる。
ユーザーにPythonインタプリタを別途インストールする負担をかけたくない場合に便利。
py2exeパッケージは、GUI付き実行可能ファイルの作成にも使える。
```Python:hello.py
print('Hello, world!')
input('Press <enter>')
```

この場合もまず空のディレクトリに、このコードを含むファイルをhello.pyという名前で作成し、次のようなsetup.pyファイルを作成する。
```
from distutils.core import setup
import py2exe

setup(console=['hello.py'])
```

このあと次のコマンドを実行する。
```
python setup.py py2exe
```

これでサブディレクトリdistの中に、コンソールアプリケーション(名前はhello.exe)とその他に数個のファイルが作成される。
このプログラムはコマンドラインからでも、ダブルクリックでも実行できる。
macOSを使っている場合は、macOS向けに同様な機能を提供するpy2appも確認するとよい。


### PyPIへのパッケージの登録

ユーザーがpipを使ってパッケージをインストールできるようにしたい場合は、そのパッケージをPyPI(Python Package Index)に登録する必要がある。標準ライブラリのドキュメントに詳しい仕組みが説明されている。
基本的には次のコマンドを使う。
```
python setup.py register
```

これでログインまたは新規ユーザー登録のメニューが表示される。
パッケージを登録すると、uploadコマンドでPyPIにアップロードできる。
次のコマンドを実行すると、ソース配布物をアップロードする。
```
python setup.py sdist upload
```

## プロトタイプづくり

### 設定・構成ファイル

設定・構成用の変数をモジュールの内のどれかの先頭に置く代わりに、別個のファイルに入れることができる。
最も簡単な方法は設定用に別個のモジュールを設けること。
たとえば、PIをモジュールファイルのconfig.py内で設定したなら、(メインプログラムの中で)次のように記述できる。
```
from config import PI
```
そうすれば、PIで異なった値を使いたいユーザーは、config.pyを編集するだけで済む。

設定ファイルの利用には「トレードオフ」がある。
設定ファイルは便利だが、一方で、プロジェクト全体の一元化した変数用共有リポジトリを使うことになる。
モジュール性が低下してモノリシック(一枚岩的)な状態になる。
抽象化(カプセル化など)を損なわないようにする必要がある。

他には標準ライブラリのconfigparserモジュールを使う方法がある。
設定ファイルとして標準的な形式を扱える。
この方法では、以下2つの形式が使える。

1つ目はPythonの通常の代入構文(引用符で囲む必要がある)。
```
greeting = 'Hello, world!'
```

もう1つは、多くのプログラムで使われている次の形式。
```
greeting: Hello, world!
```

設定ファイルは[files]や[colors]などのヘッダを使って「セクション」に分割しなければならない。
セクション名は任意だが[...]で囲む必要がある。
設定ファイルの見本とそれを使うプログラムを示す。
```txt:listing19-1.cfg
[numbers]

pi: 3.14159265897931

[messages]

greeting: 面積計算プログラムです
question: 半径を入れてください:
result_message: 面積は次のとおりです:
```

ConfigParserを使ったプログラム
```Python:listing19-1.py
from configparser import ConfigParser

CONFIGFILE = "Chapter19/listing19-1.cfg"
# CONFIGFILE = "area.ini"

config = ConfigParser()
# 設定・構成ファイルから読み込み
config.read(CONFIGFILE)

# 初期設定を出力
# 'messages' のセクションを見る
print(config['messages'].get('greeting'))

# radius(半径)を読み込むためのメッセージ(question)を読み込む
radius = float(input(config['messages'].get('question') + ' '))

# 結果を出力
# endをスペースに設定して改行しない
print(config['messages'].get('result_message'), end=' ')

# getfloat()を使って、値をfloat(浮動小数点数)に変換
print(config['numbers'].getfloat('pi') * radius**2)
```


設定のレベル

* 設定ファイル
* 環境変数：辞書os.environを使って取得可能
* コマンドラインでプログラムに渡すスイッチや引数：引数に関してはsys.argvを使って直接処理できる。


### ロギング

プログラムに関するデータを実行時に収集することで、これを使って実行後や実行中にプログラムの様子を調査できる。
プログラムの先頭で次のような文を書いておくことで、「ログファイル」をオープンする。
```
log = open('logfile.txt', 'w')
```

以降、関心のある情報を次のように書き込むことができる。
```
print('次のURLからファイルをダウンロード中:', url, file=log)
text = urllib.urlopen(url).read()
pritn('ファイルダウンロード正常終了', file=log)
```

この方法は、ダウンロード中にプログラムが異常終了するとうまくいかない。
各logを取るたびにファイルのオープンとクローズ(または少なくとも書き込み後にそのファイルをフラッシュ)すれば、安全性は増す。
実際には、標準ライブラリのloggingモジュールを使うのがよい。
```Python:listing19-2.py
import logging

logging.basicConfig(level=logging.INFO, filename='mylog.log')

logging.info('実行開始')
logging.info('1を0で割る')
print(1 / 0)
logging.info('割り算成功')
logging.info('実行終了')
```

このプログラムを実行すると、次のようなログファイル(mylog.log)が作成される。
```
INFO:root:実行開始
INFO:root:1を0で割る
```

1を0でわろうとした後は、このエラー(0による除算)によってプログラムが異常終了するため、何もログに記録されない。
loggingモジュールに相応の設定をすればロギングの動作を調整できる。


## テキストからHTMLへの変換

```Powershell
cat .\Chapter20\test_input.txt | python.exe Chapter20/markup.py > test_output.html
```


## 図の描画

日本語文字の表示  
https://gammasoft.jp/blog/pdf-japanese-font-by-python/


ReportLab(https://www.reportlab.com)
```
pip install reportlab
```


## XML解析処理

```
from xml.sax import make_parser
parser = make_parser()
```
これで例外が発生しなければサンプルプログラムの確認ができる。


## ネットニュースの取得と表示

```
from nntplib import NNTP
server = NNTP('news.foo.bar')
server.group('comp.lang.python.announce')[0]
```


## XML-RPCを使ったファイル共有
```
from xmlrpc.server import SimpleXMLRPCServer
s = SimpleXMLRPCServer(("", 4242))
def twice(x):
    return x * 2

s.register_function(twice)
s.serve_forever()
```

```
from xmlrpc.client import ServerProxy
s = ServerProxy('http://localhost:4242')
s.twice(2)
```

動作確認
```
python Chapter24/simple_node.py http://localhost:4242 files1 secret1
```
```
python Chapter24/simple_node.py http://localhost:4243 files2 secret2
```

別ターミナルでインタプリタを起動
```
from xmlrpc.client import *
mypeer = ServerProxy('http://localhost:4242')
code, data = mypeer.query('test.txt')
code

otherpeer = ServerProxy('http://localhost:4243')
code, data = otherpeer.query('test.txt')
code

data

mypeer.hello('http://localhost:4243')

mypeer.query('test.txt')

mypeer.fetch('test.txt', 'secret1')
```

urls.txt
```
http://localhost:4243
```

server.py 実行
```
python server.py http://localhost:4243 files1 secret1
```

client.py 実行
```
mkdir directory     # directoryが存在しなければ作成
python client.py urls.txt directory http://localhost:4242
> help fetch
> fetch fooo        # ファイルが見つかりませんでした
> fetch test.txt    # ファイルがdirectoryにコピーされる
```

## ファイル共有アプリケーションのGUI化

シンプルなGUIクライアント実行
```
python simple_guiclient.py urls.txt files/ http://localhost:8000
```

完成したGUIクライアント実行
```
python guiclient.py urls.txt files/ http://localhost:8000
```

## アーケードゲームの作成

Pygame(https://pygame.org)
```
pip instal pygame
```

実行
```
python weights.py
```
