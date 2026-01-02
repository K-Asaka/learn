# 学習記録用リポジトリ

## 1週間で学べるLaTeXの基礎が学べる本


タイプセット：LaTeXのソースコードを文書に変換すること


## LaTeXの環境構築

Cloud LaTeX
https://cloudlatex.io/ja


ArchLinux

日本語関連パッケージ
sudo pacman -S texlive-langjapanese texlive-luatex texlive-latexextra texlive-fontsextra otf-latin-modern

更新
luaotfload-tool --update

確認用
sudo pacman -S evince poppler-data 

タイプセット
lualatex <ファイル名>.tex

PDF表示
evince <ファイル名>.pdf


## プリアンブル部
\begin{document}よりも前の部分をまとめてプリアンブル部と呼ぶ。

\documentclass{ltjsarticle} - ドキュメントクラス(文書全体のレイアウトの指定)
- 読み込むパッケージ
- 文書のレイアウトの基本情報
\title{文書のタイトル}      - 文書のタイトル
\author{著者名}             - 著者
\date{\todya}               - 日付


## 本文
\begin{document}と\end{document}に囲まれた部分。
\sectionを使うと本文中に見出しを挿入できる。
他にも様々な見出しを生成する専用の命令(\subsection、\paragraphなど)が用意されている。


## ドキュメントクラス
LuaLaTeXではドキュメントクラスの冒頭に`lt`を付ける
jarticle    日本語の論文(japanese article)
jsarticle   jarticleより余白が狭くなり、書体が変わる
jsbook      文書全体が教科書のように表示される


## eqnarray環境は使わない
align環境とほぼ同じ機能を持つ環境。
現在使用は推奨されていない。


## 索引

lualatex file.tex

実行後に

upmendex file.idx (または makeindex file.idx)

を実行してindファイルを作成する。
その後、改めて

lualatex file.tex

を実行する。


## 文献

参考文献の数が多い場合は、文献データベース(BibTex)を使い次の手順で管理することができる。

- 文献データベース(.bibファイル)を別に作成する
- 文中からそれを呼び出す


## パッケージのインストール
mhchem

ダウンロード
```
$ cd ~/Downloads
$ curl -LO https://mirrors.ctan.org/macros/latex/contrib/mhchem.zip
$ curl -LO http://mirrors.ctan.org/macros/latex/contrib/chemgreek.zip
```

展開
```
$ unzip ~/Downloads/mhchem.zip
$ unzip ~/Downloads/chemgreek.zip
```

styファイルの置き場所確認
```
$ kpsewhich amsmath.sty
```

上記コマンドで`latex/`のパスを確認。仮に`/usr/share/texlive/texmf-dist/tex/latex/`とする。

展開したファイルの移動
```
$ sudo mv ~/Downloads/mhchem /usr/share/texlive/texmf-dist/tex/latex/
$ sudo mv ~/Downloads/chemgreek /usr/share/texlive/texmf-dist/tex/latex/
```

更新
```
$ sudo mktexlsr
```

