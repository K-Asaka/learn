# 学習記録用リポジトリ

Linux プログラミング

gccがインストールされているか確認
gcc -dumpversion

インストール方法
Ubuntu:
sudo apt-get install build-essential

CentOS:
sudo yum groupinstall "Development Tools"


コンパイラによるコードチェック
gcc -Wall
一般的な警告オプションがすべてオンになる

コンパイラによる最適化
gcc -O2
最適化オプション-O1(-O)、-O2、-O3
数字が大きいほうが強力な最適化が行われる


コマンドライン引数
argcとargv
argcは渡されたコマンドライン引数の数、argvがコマンドライン引数の実態(文字列の配列)

./hello x y z

argv[0]→./hello\0
argv[1]→x\0
argv[2]→y\0
argv[3]→z\0


stdioの動作を確かめる
straceのインストール

AlmaLinux:
sudo dnf install strace

straceを使って確認
strace ./hello >/dev/null

4096バイトのデータを作成
for i in `seq 1 4096`;do echo -n "a" >> data; done

catとcat2(stdio)の違いを確認
strace -e trace=open,read,write,close ./cat data >/dev/null
strace -e trace=open,read,write,close ./cat2 data >/dev/null


gdbを使ったデバッグ
あらかじめバグを仕込んだhead.cを使って確認
gdbを使うには、あらかじめgccに-gオプションを付けてプログラムをビルドしておく必要がある。

gcc -Wall -g -o head head.c

原則として最適化オプションは付けない
デバッグしたいプログラム名とともにgdbを起動する

gdb ./head


rnuコマンド
runコマンドにオプションを付けると、そのオプションをそのままプログラムに付けて実行する
引数が不正な値になっているためsegmentation faultが発生しプログラムが停止する

(gdb) run -n 5


backtraceコマンド(bt)
現在実行中の関数が呼び出し順の逆に列挙される
atoi()

(gdb) backtrace


frameコマンド(f)とlistコマンド(l)
問題の箇所を確認するためframeコマンドでmain()に移動する
backtraceコマンドの出力のうちmain()の行を確認
先頭の「#」に続く番号を指定する

(gdb) frame 1

現在の関数がmain()になり、実行中の行が表示される
広い範囲を見たければlistコマンドで表示できる

(gdb) list


printコマンド(p)
atol()の引数optargの値を調べるため、printコマンドを使う

(gdb) print optarg


quitコマンド(q)
gdbの終了
プロセスが稼働している場合は終了するかどうか聞かれる

(gdb) quit


