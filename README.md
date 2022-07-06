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

