# 学習記録用リポジトリ

## Ruby学習用

### irbコマンドを使う方法

コンソールに `irb` と入力して実行する。
終了するときは `exit` と入力してEnterキーを押すか、Ctrlキーを押しながらdきーを押す。

### コマンドラインオプションでの出力用文字コードの指定

`ruby -E UTF-8 スクリプトファイル名`

`irb -E UTF-8`

### --simple-promptオプション

`irb` に `--simple-prompt` オプションをつけると、irbのプロンプト表示を簡易にすることができる。

### メソッドの表記法

ドキュメントや説明のための表記法。

`クラス名#メソッド名`

クラスメソッドの名前の表記。

`クラス名.メソッド名`
`クラス名::メソッド名`

### 引数の数が不定なメソッド

引数の数が決められないメソッドは、「*変数名」の形式で定義することで、与えられた引数をまとめて配列として得られる。

```ruby
def foo(*args)
    args
end

p foo(1, 2, 3) #=> [1, 2, 3]
```

少なくとも1つは指定しないといけない引数があるメソッドを定義するには次のようにする。

```ruby
def meth(arg, *args)
    [arg, args]
end

p meth(1)       #=> [1, []]
p meth(1, 2, 3) #=> [1, [2, 3]]
```

不定の引数はすべてargsという変数に配列として渡される。「*変数名」の形式の引数は、メソッド定義の引数リストに1つだけ含めることができる。最初の引数と最後の引数は決まった名前で受け取って、その間の引数は省略できるようにしたい場合、次のようにする。

```ruby
def a(a, *b, c)
    [a, b, c]
end

p a(1, 2, 3, 4, 5) #=> [1, [2, 3, 4], 5]
p a(1, 2)          #=> [1, [], 2]
```

### キーワード引数

引数名と値のペアで引数を渡せるようになる。

```ruby
def メソッド名(引数1: 引数1の値, 引数2: 引数2の値, …)
    実行したい処理
end
```

引数名だけでなくデフォルト値を指定する。以下は参考例。

```ruby
def area2(x: 0, y: 0, z: 0)
    xy = x * y
    yz = y * z
    zx = z * x
    (xy + yz + zx) * 2
end

p area2(x: 2, y: 3, z: 4) #=> 52
p area2(z: 4, y: 3, x: 2) #=> 52(引数の順序を変える)
p area2(x: 2, z: 3)       #=> 12(yを省略する)
```

デフォルト値を指定したくない場合は、「**引数名:**」と引数名だけ書く。デフォルト値が省略された引数は、呼び出し時に省略できない。
また、定義にない引数名でパラメータを与えた場合はエラーとなる。

定義に存在しないキーワード引数をエラーにせずに受け取りたい場合は「**変数名」の形式で受け取る。

```ruby
def meth(x: 0, y: 0, z: 0, **args)
    [x, y, z, args]
end

p meth(z: 4, y: 3, x: 2)       #=> [2, 3, 4, {}]
p meth(x: 2, z: 3, v: 4, w: 5) #=> [2, 0, 3, {:v=>4, :w=>5}]
```

### ハッシュで引数を渡す

ハッシュをキーワード引数として渡すことができる。キーはシンボルでなければならない。デフォルト値を持つキーワードは省略してかまわないが、余分なキーを与えるとエラーになる。

```ruby
def area2(x: 0, y: 0, z: 0)
    xy = x * y
    yz = y * z
    zx = z * x
    (xy + yz + zx) * 2
end

args1 = {x: 2, y: 3, z: 4}
p area2(args1)        #=> 52

args2 = {x: 2, z: 3}  # yを省略する
p area2(args2)        #=> 12
```

### メソッドの呼び出しの補足

#### 配列を引数に展開する

配列を展開してメソッドの引数にすることができる。メソッドの呼び出しの際に、「*配列」の形式で引数を指定すると、配列そのものではなく、配列の要素が先頭から順にメソッドの引数として渡される。ただし、配列の要素の数とメソッドの引数の数は一致していないといけない。

```ruby
def foo(a, b, c)
    a + b + c
end

p foo(1, 2, 3)    #=> 6

args1 = [2, 3]
p foo(1, *args1)  #=> 6

args2 = [1, 2, 3]
p foo(*args2)     #=> 6
```

### 引数にハッシュを渡す

ハッシュオブジェクトは通常「{ 〜 }」という形式で書くが、メソッドの引数にハッシュを渡す場合は省略できる。

```ruby
def foo(arg)
    arg
end

p foo({"a"=>1, "b"=>2})     #=> {"a"=>1, "b"=>2}
p foo("a"=>1, "b"=>2)       #=> {"a"=>1, "b"=>2}
p foo(a: 1, b: 2}           #=> {:a=>1, :b=>2}
```
