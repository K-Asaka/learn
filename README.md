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

