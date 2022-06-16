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
