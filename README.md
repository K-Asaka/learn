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

