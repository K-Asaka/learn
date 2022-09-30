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


### rustupのその他の機能

rustupには以下の機能がある。
1. 複数バージョンのRustツールチェインのインストールと管理
2. クロスコンパイル用ターゲットのインストール
3. RLSなどの開発支援ツールのインストール


#### ●複数バージョンのRustツールチェインのインストールと管理

```
rustup show
```
以下の情報を表示する
- インストール済みのツールチェイン
- 現在アクティブになっているツールチェイン

#### ●追加のツールチェイン

```
rustup install ツールチェイン名
```

nightlyチャンネルから最新のnightly版をダウンロードしてインストールする。
```
rustup install nightly
```

ツールチェイン名  
| ツールチェイン名 | 例 | インストールされるツールチェイン |
| --- | --- | --- |
| チャネル名 | stable | 最新版 |
| | beta | 最新版 |
| | nightly | 最新版 |
| nightly-作成日付 | nightly-2018-11-12 | 指定した日付に作成されたnightly版 |
| バージョン | 1.31.0 | 指定したバージョンの安定版 |
| | 1.32.0-beta.2 | またはベータ版 |


#### ●ツールチェインを最新版にアップデートする

```
rustup update
```


#### ●デフォルトのツールチェイン

rustupのインストール時にデフォルトのツールチェインが設定される。インストール時の設定を変更しなかった場合はstableがデフォルトになる。  

デフォルト以外のツールチェインに属するコマンドを実行する場合。
```
rustup run nightly rustc -V

# 上のコマンドの省略形
rustc +nightly -V

# Nightly版のcargoを実行してバージョンを表示
cargo +nightly -V
```


### ●特定のパッケージのみでnightlyを使用する

パッケージのトップディレクトリにrustup-toolchainというファイルを作成してツールチェイン名を書き込むと、指定したツールチェインが使われるようになる。

```
cd パッケージのディレクトリ
echo nightly > rust-toolchain
```


### ●クロスコンパイル用ターゲットのインストール

ターゲットを追加するにはrustup target addコマンドを使う。

Linuxのデフォルトのターゲットを追加する。
```
rustup target add x86_64-unknown-linux-musl
```

ツールチェインとターゲットには親子関係があり、1つのツールチェインに複数のターゲットが属する。
デフォルト以外のツールチェインにターゲットを追加するには`--toolchain ツールチェイン名`オプションを使用する。
```
rustup target add x86_64-unknown-linux-musl --toolchain nightly
```


### ●その他の使い方

- ソースコードからビルドしたRustツールチェインを任意の名前で登録して使用する。
    - localという名前で登録すると`cargo +local build`のように実行できる。
- Rustツールチェインの配布サーバを指定する
    - 緊急のポイントリリースが行われる際、そのリリース候補版の配布には通常時と異なる配布サーバが使われる。

rustup-initのコマンドラインオプション
- インストールするツールチェイン(デフォルトのツールチェイン)を変更する。
- ツールチェインのインストール先を変更する。
- 非対話形式でインストールする。


### Advanced Rust, by Nicholas Matsakis (RustConf2016)
http://www.rust-tutorials.com/RustConf16/3-Advanced-Lifetimes.pdf



# パッケージの公開方法
## パッケージのビルド
`cargo build`コマンドを利用してパッケージをビルドする。
オプションなしの`cargo build`は開発用のビルドコマンド。
ビルドされたファイルは、`target/debug`ディレクトリに出力される。

```
$ cargo build
```

`--release`フラグを付けてビルドするとリリース向けのビルドになる。
最適化が有効になり数十倍から百倍ほど早くなる他、整数のオーバーフローでパニックしなくなるなど多少バイナリに違いが出る。

```
$ cargo build --release
```

ビルドされたファイルは`target/release`ディレクトリに出力される。
`build`の他`run`や`test`などのサブコマンドも`--release`フラグを取れ、リリースビルドで実行やテストを行える。

## 作業のコミット
`cargo new`コマンドで初期化されたパッケージは、デフォルト設定ではバージョン管理システム(VCS)のGitリポジトリとしても初期化されている。
どのVCSとして初期化するかは`--vcs`フラグでVCSをMercurial、pijul、Fossilなどを切り替えられる。

パッケージを公開するには、変更したファイルはGitにコミットしておく必要がある。
`git status`コマンドで、Gitの状態を確認する。
`cargo`コマンドによって作成されたファイルがGit管理下にない(Untracked filesとなっている)ことが分かる。

```
$ git status
```

`cargo new`コマンドで`Cargo.toml`や`src/main.rs`以外にも`.gitignore`も生成されているのが分かる。
`.gitignore`にはGitで管理しないファイルが書かれている。
たとえばビルド成果物が保存される`target/`ディレクトリはUntracked filesのリストに入っていないが、これは`.gitignore`で無視されるから。

パッケージに必要なファイルをGit管理下に追加するには`git add`を実行する。

```
$ git add .
```

変更をコミットする。コミットには分かりやすいメッセージを付けておく。

```
$ git commit -m 'Initial Commit'
```

`git log`コマンドでコミットの結果を確認できる。

```
$ git log
```

## リモートリポジトリの追加
Gitは分散VCSのため、ローカルマシンの管理履歴をリモートリポジトリに反映させることができる。
### GitHubを利用する場合
GitHubにwordcountリポジトリを作っておく。
ローカルのリポジトリについて、GitHubのリポジトリを紐付ける。
リモートリポジトリの追加は、`git remote add`コマンドで実行できる。

リポジトリには、複数のリモートリポジトリが紐付けできる。
リモートリポジトリには、それぞれを区別するための名前がつけられる。
慣例として、メインで利用するリモートリポジトリには`origin`と名付ける。

ローカルリポジトリについて、`origin`という名前で`git@github.com:<your_account>/wordcount.git`を紐付けるには以下のコマンドを実行する。

```
$ git remote add origin git@github.com:<your_account>/wordcount.git
```


## 自動テストを行う
GitHubのリポジトリでコードを公開することで、世界中の他のユーザとの共同作業が進めやすくなる。
反面、貢献者が増えてくるとコードの品質の担保が難しくなる。
自動化されたテストを用いる開発を継続的インテグレーション(Continuous Integration, CI)と呼ぶ。
CIのためのサービスがいくつか用意されている。

Rustはクロスコンパイルでさまざまな環境をサポートできるため、Travis CIとAppVeyorを合わせて使うことで、Linux、macOS、Windowsというメジャーなプラットフォーム上でビルドの確認やテストができる。
リリース時にそれぞれのプラットフォームに合わせたバイナリをビルドして配布することもできる。

### TravisCI
LinuxとmacOS向けの継続的インテグレーション環境。
テスト環境の設定はYAMLファイルとして記載することで、簡単にテストの設定ができる。

#### Travis CIの設定
Travis CIはGitHubと連携させて利用できる。
まずはTravis CIの設定を行う。
Travis CIのアカウントを持っていない場合は`https://travis-ci.org/`へアクセスしアカウントを作成する。

Travis CIにGitHubアカウントでサインアップすると、連携するリポジトリを選ぶ画面に遷移する。
wordcountリポジトリの左側に表示されているスライドボタンをチェック状態にすると、Travis CIでのテストが有効になる。

#### Travis CIでのテスト
リポジトリ上でTravis CIの設定のための設定ファイルを準備する。
テスト環境の設定はYAMLファイルとして記載する。
Travis CIはこのYAMLファイルを読み込んで、ファイルで指定されたテストを実行する。
リポジトリの直下に`.travis.yml`を作成し、以下の内容を記載する。

```
language: rust

os:
  - linux
  - osx

rust:
  - stable
  - beta
  - nightly

matrix:
  allow_failures:
    - rust: nightly
```

それぞれの意味は次のとおり。

* language：利用する言語を指定する。
* os：利用するOSを指定する。
* rust：Rustのバージョンを指定する。
* matrix：テスト環境ごとに設定を行う。Rustのnightlyでのテストの失敗は許可している。
* allow_failures：テストの失敗を許可する。

ここまで記述したら`.travis.yml`をGitにコミットし、リモートリポジトリにプッシュする。
Travis CIが設定ファイルを読み込んでテストを実行してくれる。

```
$ git add .travis.yml
$ git commit -m 'travis.ymlの追加'
$ git push origin master
```

プッシュ後、Travis CIをWebブラウザで開きリポジトリ一覧からwordcountリポジトリを選択すると、テストが実行されていることが確認できる。

### AppVeyor
Windows向けの継続的インテグレーション環境。
Travis CIと同じくYAML形式で設定ファイルを書ける。

#### AppVeyorの設定
AppVeyorのアカウントを持っていない場合は`https://www.appveyor.com`にアクセスしアカウントを作成する。

GitHub連携を設定する。
左のメニューから`GitHub`を選ぶとGitHub連携の選択肢がある。
`Authorize GitHub`を選択する。
パブリックリポジトリのみかプライベートリポジトリも使うか選択する。

GitHubに飛び、リポジトリへのアクセス権限が要求されるため、承認する。
すると、wordcountリポジトリが選べるようになる。
wordcountにカーソルを合わせると出てくる`Add`を押すと連携は完了。

#### AppVeyorでのテスト
プロジェクト直下に`appveyor.yml`というファイルを作り、以下の内容を書く。

```
environment:
  matrix:
    - CHANNEL: stable
      TARGET: x86_64-pc-windows-msvc
    - CHANNEL: stable
      TARGET: x86_64-pc-windows-gnu
    - CHANNEL: beta
      TARGET: x86_64-pc-windows-msvc
    - CHANNEL: nightly
      TARGET: x86_64-pc-windows-msvc

matrix:
  allow_failures:
    - channel: nightly

install:
  - appveyor DownloadFile https://win.rustup.rs/ -FileName rustup-init.exe
  - rustup-init -yv --default-toolchain %CHANNEL% --default-host %TARGET%
  - set PATH=%PATH%;%USERPROFILE%\.cargo\bin
  - rustc -vV
  - cargo -vV

build: false

test_script:
  - cargo test --verbose
```

それぞれの意味は次のとおり。

* environment：設定する環境変数の組。matrixの項目ごとにテストが実行される。
* matrix：設定した環境個別に設定を与える。nightlyのテストの失敗を許可している。
* install：ビルド前に必要なソフトウェアをインストールする。
* build：ビルドの設定を書く。後続のcargo testでビルドまでしてくれるため、ビルドをしないように設定する。
* test_script：テストコマンドを書く。

`environment`の`TARGET`について、RustはWindowsでは2種類の環境がサポートされている。
どちらの環境向けにコンパイルするかを指定するのが`TARGET`の部分。
CIで、どちらの環境でも正常に動くかをテストしようとしている。
もし1つの環境しか気にしないのであれば、他の環境のテストはしなくても大丈夫。

ここまで書けたらコミットしてリモートリポジトリにプッシュする。

```
$ git add appveyor.yml
$ git commit -m 'AppVeyorの追加'
$ git push origin master
```

AppVeyorにアクセスするとビルドされていることが分かる。


# パッケージをリリースする
wordcountをcrates.ioにリリースする。

## マニフェストファイルの修正
パッケージを公開するにあたり、必要なパッケージ情報を記載する。
`cargo new`で生成されたものは必要最低限の記述しかない。
ユーザに分かりやすいよう様々な情報を記述する。
`Cargo.toml`を以下のように書き換える。

```
[package]
name = "wordcount"
version = "0.1.0"
authors = ["your name"]
edition = "2018"
# ここから追記
license = "MIT OR Apache-2.0"
description = "シンプルな文字、単語、行の出現頻度の計数機能を提供します。"
readme = "README.md"
repository = "https://github.com/your_account/wordcount"
categories = ["command-line-utilities"]
keywords = ["example", "frequency", "text"]

[badges]
appveyor = { repository = "your_account/wordcount" }
travis-ci = { repository = "your_account/wordcount" }

# 追記ここまで

[dependencies]
regex = "0.2"
```

packageセクションのそれぞれの項目の意味は次のとおり。

* license：このパッケージのライセンスを書く。ライセンスの記述はSPDX License Listに載っている識別子とAND, ORが使える。リストに載っていないライセンスを使いたい場合は`license-file`としてライセンスファイルを指定できる。依存クレートのライセンスと互換性があるかに注意する必要がある。
* description：このパッケージの説明。
* readme：READMEファイルのパスネーム。crates.ioで公開した際に表示される。
* repository：パッケージのソースコードを管理するリポジトリ。
* categories：事前に決められたカテゴリリストの中からこのパッケージに当てはまるものを最大5つまで書く。`https://crates.io/category_slugs`に定義されたカテゴリのリストがある。
* keywords：自由なキーワードを最大5つまで書く。
* badgesセクション：ここを指定するとcrates.ioにバッヂが掲載される。

`README`ファイルをプロジェクト全体の説明として用意する。
Markdown形式でREADMEファイルを書く。

```
`wordcount`はシンプルな文字、単語、行の出現頻度の計数機能を提供します。
CLIからは単語数の出現頻度が使えます。

```console
$ cargo run text.txt
{"bb": 1, "aa": 2, "cc": 1}
```

この他にはリリースするごとに更新された内容を書く`RELEASES`、プロジェクトに貢献するときのガイドラインを示す`CONTRIBUTING`などがある。
更新したらコミットしておく。

```
$ git add .
$ git commit -m 'Cargo.tomlの更新、README.mdの追加'
```

## 最終確認
crates.ioは今まで動いていたものが壊れるのを防ぐため、パッケージの削除をできないようにしている。
一度リリースしてしまったら取り消すことができない。

まずパッケージ名を見直す。
書籍のサンプルとして作ったコードを例に取っているため、分かりやすい名前にする。

```
[package]
name = "bicycle-book-wordcount"

#...
```

ソースコード内のwordcountクレートを参照している箇所と`README.md`を`bicycle_book_wordcount`に書き換える。
この状態で`--release`フラグ付きでテストが通るか確認しておく。

```
$ cargo test --release
```

libクレートの方はもう一度ドキュメントを生成し、確認する。

```
$ cargo doc --no-deps --open
```

binクレートの方は一度インストールしてみて動作を確認する。

```
$ cargo install --path .
$ bicycle-book-wordcount text.txt
```

問題なさそうならコミットする。

```
$ git add .
$ git commit -m 'パッケージ名の変更(wordcount -> bicycle-book-wordcount)'
```

公開する前に`cargo package`でいったん成果物の確認をする。
この時点で簡単な不備はエラーとして検出してくれる。

```
$ cargo package
```

このコマンドが成功したらならば些細な不備はない。成果物は`target/package`にある。
これはGZ圧縮したtarballなので、関連ユーティリティコマンドで内容物を確認できる。

```
$ zcat target/package/bicycle-book-wordcount-0.1.0.crate | tar tf -
```

パッケージに`text.txt`や`tests/`など不要なファイルが含まれている。
これらをパッケージに含めないようにする。
`Cargo.toml`に`excludes`が書ける。
`package`セクションの末尾に以下を追記する。

```
[package]
# ...
exclude = ["text.txt", "tests/*"]

[badges]
# ...
```

`excludes`はリストをとり、それぞれにパスネームのグロブがとれる。
もう一度`cargo package`する。

```
$ cargo package
```

今度はエラーになる。これはコミットしていないファイルがあるため。
編集した`Cargo.toml`をコミットする。

```
$ git add Cargo.toml
$ git commit -m 'パッケージにテスト関連ファイルを含めないように修正'
```

もう一度`cargo package`を実行する。

```
$ cargo package
```

内容物を確認しても余計なファイルが入っていないか確認する。

ここまで確認して問題がなければGitにタグを打つ。
タグとは特定のコミットに名前を付けたもの。

```
$ git tag v0.1.0
```

タグには`v{パッケージのバージョン}`を指定することが多い。
これまでの変更をGitHubにプッシュしておく。
同時に今付けたタグもプッシュする。

```
$ git push origin master
$ git push origin v0.1.0
```

これで設定したCIが完了するのを待つ。
もしバイナリリリースも設定している場合は、可能ならダウンロードして動かしてみる。


### パッケージ名の-と_

Rustではパッケージ名にはケバブケースが推奨されている。
しかし、Rustプログラム内から扱うときは`-`は識別子として使えないため、スネークケースで扱わなければならないため、注意が必要。


### crates.ioでの公開

crates.ioでの公開は一度ユーザを作ってしまえばCargoでできるので簡単。

#### crates.ioへのユーザ登録とトークンの設定

crates.ioへのユーザ登録はGitHubでできる。  
`Login with GitHub`を選択し、GitHubでcrates.ioからのアクセスを承認する。  
サインアップはこれで終了。

APIトークンを発行する。  
`Account Settings`へ移動する。  
Emailアドレスを設定し、`New Token`を選択。
トークンとコマンドが表示されるので、そのまま実行する。

```
$ cargo login <Your API TOKEN>
```

ログイン処理は一度だけ行えば、以降必要ない。


#### パッケージのCLIからの公開

`cargo publish`で公開できる。

```
$ cargo publish
```

crates.ioの自分のアカウントにアクセスすると、`bicycle-book-wordcount`が公開されていることが分かる。


#### クレートのドキュメント

crates.ioで公開したパッケージのドキュメントは、`docs.rs`というサイトで自動的に生成、公開される。
今回のクレートのドキュメントは`https://docs.rs/crate/bicycle-book-wordcount`で確認できる。

ほとんどの場合はこの自動生成機能で問題ない。
開発版のドキュメントをホスティングしたいなどの場合は、`cargo docs`で生成して管理することもできる。


### バイナリのリリース

Rustコンパイラはネイティブバイナリを生成できるので、事前にバイナリをコンパイルして用意してあればRustユーザ以外も簡単にRust製のプロジェクトを利用できる。
これは利用しているツールやサービスのいくつかの機能を組み合わせると実現できる。

* Gitのタグ
* GitHubのリリース
* Travis CIやAppVeyorのデプロイ

今回のwordcountの0.1.0公開時のソースコードにタグを付けるとしたら、以下のようなコマンドを発行する。

```
$ git tag v0.1.0
```

次に、GitHubにはリリース機能がある。
これはGitのタグに関連付けてリリースノートやファイルを用意する機能。
crates.ioに登録するたびにGitのタグを打てば、GitHubのリリース機能を用いて各バージョンに対応するバイナリを置く場所が用意できる。

そしてTravis CIやAppVeyorのデプロイ機能を用いると、CIの成果物をGitHubのリリースに置くことができる。元々CIでは各種環境でビルド、テストを実行しているので動作テスト済みのバイナリが生成されている。
これらを特定のタイミング、たとえばGitのタグを打ったときにGitHubにアップロードするように設定することで、自動で複数のプラットフォーム向けのバイナリを用意できる。
以下のリポジトリにはTravis CIとAppVeyorのテンプレートがあるので参考にするといい。

`https://github.com/japaric/trust`


## Dieselを使ったデータベースの扱い

### diesel_cliのインストール
CLIツールをビルドするのに、DBのクライアントライブラリが必要。

#### PostgreSQLを利用する場合
* macOS  
`/usr/lib`に`libpq*.dylib`が入っていれば大丈夫。

* Ubuntu
```
$ sudo apt-get install -y libpq-dev
```

* Windows - Powershell  
まず、サンプルコードのGitHubリポジトリにある説明を参照しvcpkgをインストールする。

```
> cd $env:VCPKG_ROOT
> .\vcpkg --triplet x64-windows-static install libpq
```
環境変数`RUSTFLAGS`を設定する。
```
# ライブラリと静的リンクするためのオプション
# rustc 1.19.0か、それ以降のバージョンが必要
> $env:RUSTFLAGS = '-Ctarget-feature=+crt-static'
```

この設定はdiesel_cliだけでなく、log-collectorをビルドするときにも必要。
また`VCPKG_ROOT`も正しく設定されている必要がある。
libpqが準備できたら以下のコマンドを実行する。

```
$ cargo install diesel_cli --no-default-features --features postgres
```

デフォルトだと対応しているすべてのDBバックエンドに対応したバイナリがインストールされ、それぞれの開発用ヘッダなどを要求される。

### PostgreSQLの準備

Docker Composeでセットアップする。
`docker-compose.yml`に以下を記述。

```
postgres-data:
  image: busybox
  volumes:
  - /var/lib/postgresql/log-collector-data
  container_name: log-collector-postgres-datastore

postgresql;
  image: postgres
  environment:
    POSTGRES_USER: postgres
    POSTGRES_PASSWORD: password
  ports:
    - "5432:5432"
  volumes_from:
    - postgres-data
```

この`docker-compose.yml`を使ってDBマネジメントシステムを立ち上げ、Dieselによる初期化を行う。`diesel setup`でプロジェクトのDiesel関連ファイルとDBのスキーマを初期化する。

```
# PostgreSQLのサーバを立ち上げる
$ docker-compose up -d

# Dieselのために環境変数を設定する
# Linux、macOS
$ export DATABASE_URL = postgresql://postgres:password@localhost:5432/log-collector
# Windows PowerShell
> set $env:DATABASE_URL='postgresql://postgres:password@localhost:5432/log-collector'

$ cd server
$ diesel setup
# log-collectorDBが作られ、migrationsディレクトリができる
# DATABASE_URLを設定しない場合は、diesel setup --database-url "DB"で設定
```

`diesel migration generate MIGRATION_NAME`でマイグレーションのひな形を生成できる。

```
$ diesel migration generate create_logs
```

`up.sql`にDBへの変更を、`down.sql`にその変更を取り消す処理を書く。

up.sql
```
-- Your SQL goes here

CREATE TABLE logs (
  id BIGSERIAL NOT NULL,
  user_agent VARCHAR NOT NULL,
  response_time INT NOT NULL,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
```

down.sql
```
DROP TABLE IF EXISTS logs;
```

完了したら以下のコマンドでマイグレーションを走らせる。

```
$ diesel migration run
```

このコマンドを走らせると自動で`schema.rs`にテーブルスキーマに対応するRustのコードが生成される。
また、`diesel.toml`というDieselのコンフィギュレーションファイルも生成される。

`down.sql`がちゃんと書けているか確認のため、一度`redo`も走らせておく。
このコマンドは一度`diesel migration revert`をしてから`diesel migration run`をするので、`down.sql`の動作テストに向いている。

```
$ diesel migration redo
```

## C FFI

各プラットフォームのCビルド方法。

### Linux

コンパイラに`-c`オプションを指定しオブジェクトファイルを生成する。

```
$ gcc -c -o target/debug/native/fib.o c_src/fib.c
```

オブジェクトファイルから静的リンクライブラリ(libfib.a)を作成する

```
$ ar r target/debug/deps/libfib.a target/debug/native/fib.o
```


### macOS

コンパイラに`-c`オプションを指定しオブジェクトファイルを生成する。

```
$ clang -c -o target/debug/native/fib.o c_src/fib.c
```

オブジェクトファイルから静的リンクライブラリ(libfib.a)を作成する。

```
ar r target/debug/deps/libfib.a target/debug/native/fib.o
```


### Windows MSVC

コンパイラに/cオプションを指定しオブジェクトファイルを生成する。

```
> cl /c c_str\fib.c
> mv fib.obj target\debug\native\
```

オブジェクトファイルから静的リンクライブラリ(fib.lib)を作成する

```
> lib /out:target\debug\deps\fib.lib target\debug\native\fib.obj
```
