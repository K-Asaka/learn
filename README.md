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
