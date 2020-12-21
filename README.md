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


