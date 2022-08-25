# 学習記録用リポジトリ

## 実践Rust入門

### Rustツールチェインのインストール

rustupを使ってRustツールチェインをインストールする。
WindowsではLinkerのインストールが事前に必要。

- ターミナルからコマンドを実行する場合
`curl https://sh.rustup.rs -sSf | sh`

- Windowsの場合
インストーラー(rustup-init.exe)をダウンロードし、インストールする。
「Install the C++ build tools before proceeding」などと表示された場合はリンカのインストールが必要。

```
1) Proceed with installation (default)
2) Customize installation
3) Cancel installation
```

設定に問題がなければ、1を入力して最新のstable版をインストール。
インストール直後はパスが通っていないため、システムにログインし直すか、以下のコマンドを実行する。

```
※Linux、macOS
source $HOME/.cargo/env

※Windows(Powershellの場合)
$Env:Path += ";$Env;USERPROFILE\.cargo/bin;"
```

### パッケージの作成

```
cd 作業用のディレクトリ
cargo new hello
```

helloディレクトリの中にひな型となるファイルが作られる。


### binクレートとlibクレート

helloパッケージではsrcディレクトリ配下にmain.rsが作られる。
cargo newコマンドに、--binか--libのどちらかのオプションを指定できる。

- --binオプション
    - バイナリパッケージが作られる。src/main.rsを持ち、ビルドすると実行可能バイナリファイルができる。
- --libオプション
    - ライブラリパッケージが作られる。src/lib.rsを持ち、ビルドするとrlibという他のRustパッケージから再利用できるライブラリファイルができる。

Cargoを使うとこれらのパッケージをインターネットで公開できる。Rustのパッケージはクレートとも呼ばれるため、Rustユーザーはバイナリパッケージを「binクレート」、ライブラリパッケージを「libクレート」と呼ぶ。
cargo newに--binも--libも与えなかった場合、binクレートが作られる。


## Cargo.tomlファイル

クレートの名前や作者名などが書かれる。
この情報はクレートをcrates.ioというRustパッケージのセントラルリポジトリに公開するときにも使われる。また、ここに依存クレートの情報を書くことで、crates.ioやGitHubのリポジトリなどから必要なクレートをダウンロードできる。

```:hello/Cargo.toml
[package]           # パッケージセクションの始まり
name = "hello"      # 名前
version = "0.1.0"   # バージョン
authors = [ "Your Name <you@example.com>" ] # 作者(複数指定可)
edition = "2018"    # 使用するRustのエディション

[dependencies]      # 依存クレートセクションの始まり
```

### パッケージのビルド

```
cargo build
```

ビルドに成功するとtarget/debugディレクトリに、hello(Windowsではhello.exe)というバイナリが作成される。
OSに応じてApplication Binary Interface(ABI)に準拠した実行可能ファイルが作成される。

### プログラムの実行

```
# Linux、macOSの場合
./target/debug/hello

# Windowsの場合
.\target\debug\hello.exe
```

Cargoから実行する場合
```
cargo run
```

cargo buildを省略してcargo runとしても構わない。
cargo cleanでビルド済みのバイナリを削除できる。削除後にcargo runを実行すると、ビルド後にバイナリが実行される。


## プログラムの内容

関数定義の基本構文
```
fn 関数名(引数1: 型1, 引数2: 型2, ...) -> 戻り値の型 {
    関数の本体
}
```

2つの数を引数に取り、それらを足した数を返す関数の定義
```
// x + yを計算する。f64型は64ビット浮動小数点数
fn add(x: f64, y: f64) -> f64 {
    // 本体に書いた最後の式の評価結果が関数の戻り値になる
    x + y
}
```

引数を1つも取らない関数や値を返さない関数も定義できる。
```
fn main() {
    println!("Hello, world!");
}
```

println!()のように名前の最後に!(感嘆符)のついたものはマクロ。コンパイルの初期段階で評価され、定義に従って別のソースコードへと展開される。


## 新エディションへの移行を支援するcargo fixコマンド

Rust Edition Guideで各エディションの代表的な機能や、新しいエディションへの移行手順などが解説されている。

非公式の和訳版 https://doc.rust-jp.rs/edition-guide

cargo fixはあtらしいエディションへの移行を支援するコマンド。2015エディション向けのコードを2018エディションに対応するコードへと自動変換できる。

```
cargo fix --edition --bin ソースファイル
```

コードを2018エディションで推奨される書き方へ修正する場合は--edition-idiomsを使う。
Gitにコミットしていない修正を無視するためには--allow-dirtyオプションが必要。

```
cargo fix --edition-idioms --allow-dirty --bin ソースファイル
```
