# 学習記録用リポジトリ

## Haskell入
## 関数型プログラミング言語の基礎と実践


## 実行環境の構築
Stack
---
- Linux/macOS
```
curl -sSL https://get.haskellstack.org/ | sh
```

macOSの場合は`xcode-select --install`でツールを追加する。
インストール成功後、stackコマンドが実行できるようになる。
Stack本体のアップグレードは`stack upgrade`コマンドから行う。

- Windows
Stackのダウンロードページより、自分の環境に合わせてインストーラをダウンロードし、実行する。
インストール成功後、コマンドプロンプトやPowerShellから`stack`コマンドが実行できるようになる。
---

[ GHC ]
```
stack setup
```

## Haskellスクリプトの実行
```
stack runghc スクリプト名.hs
```

## REPLにスクリプトを読み込む
```
Prelude> :load スクリプト名.hs
```
REPLに読み込んだ後にスクリプトを変更した場合
```
Prelude> :reload
```

## グローバルプロジェクト
グローバルプロジェクトの保存先の確認
```
stack path --project-root
```
グローバルプロジェクトの設定を変更するには、このディレクトリにある`stack.yaml`を編集する。

## プロジェクトの作成
```
stack new myproject
```

### ソースコードの配置
`src`と`app`というディレクトリにhsファイルを配置する。
実行ファイル関連以外の全てのモジュールは`src`へ配置し、実行ファイル用のモジュールは`app`へ配置する。

## プロジェクトのビルドと実行
- プロジェクトのビルド
```
stack build
```

- プロジェクトの実行
```
stack exec プロジェクト名-exe
```

- プロジェクトのインストール
```
stack install
```

- 単体テスト
```
stack test
```

- プロジェクト内でREPL
```
stack ghci
```
Mainモジュール(app/Main.hs)とLibモジュール(src/Lib.hs)が読み込まれる。  

- 現在読み込まれているモジュールの一覧表示
```
:show modules
```
`:show imports`と合わせて、今の状態を確認できる。

- モジュールに定義されている識別子の一覧表示  
デフォルトのLib.hsを使った場合。
```
:browse Lib
```

.hsファイルを書き換えた場合、`:reload`で変更をghciに読み込む。  
`stack.yaml`や`*.cabal`の変更があったときは、ghciを一度終了して読み直す必要がある。

