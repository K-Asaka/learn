# 学習記録用リポジトリ

## プロフェッショナルWebプログラミング Vue.js

### インストール方法

1. Content Delivery Network(CDN)から直接script要素で読み込む  
インターネット上に存在するCDNサービスから読み込む方法。

2. Vue.jsのファイルをダウンロードして、script要素で読み込む  
Vue.jsの公式ドキュメントからファイルをダウンロードしてサーバに配置し、HTMLから読み込んで使用する。

3. npmを利用してインストール  
npm(Node Package Manager)を利用する方法。


- 開発モード  
Vue.js devtoolsを用いて視覚的に調査・デバッグができる。  
ソースコードは圧縮されていない。  
開発時に利用。  
```
<script src="https://unpkg.com/vue@3.0.0/dist/vue.global.js"></script>
```

- 本番モード  

```
<script src="https://unpkg.com/vue@3.0.0/dist/vue.global.prod.js"></script>
```


## Vue.js devtoolsのインストール

- Google ChromeとFirefoxの拡張機能として提供されている
- インストールしたら、「Allow access to file URLs」を有効にしておくと、ローカル環境でHTMLファイルをブラウザで直接開いたときでもVue.js devtoolsを使用できる
