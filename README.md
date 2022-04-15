# 学習記録用リポジトリ

本格Java入門　改定3版


## ■JShell

ターミナルからプログラムを直接入力し、実行するためのツール。
REPL(Read-Eval-Print-Loop)と呼ばれる。


### ●JShellの起動

`jshell オプション ファイル名`

#### JShellの起動オプション
- --help：JShellに関するヘルプを表示
- --version：JShellのバージョンを表示

#### JShellの主要なコマンド
- /list：これまでに入力した命令を表示する
- /edit：JShell Edit Padを起動する
- /drop：指定した行、idの命令を削除する
- /save：保存する
- /open：保存した命令を読み込む
- /var：変数の一覧を表示する
- /history：これまでに入力した履歴を表示する
- /reset：これまでの入力をすべてリセットする
- /exit：JShellを終了させる

### JShellの操作
```:JShell
jshell
jshell> System.out.println("Hello.");
Hello.
jshell> /exit
```
