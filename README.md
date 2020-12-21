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

