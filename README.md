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


## Vue3について

### インスタンスの作成方法

- Vue2までは`new Vue({...})`で作成していた
- Vue3では`Vue.createApp({...})`に変更された
- Vue2ではマウントはオプションオブジェクトの`el`プロパティでマウント位置を指定するか、`$mount`メソッドを使用していた
- Vue3では`mount`メソッドに変更された

```
// Vue2
new Vue({
    el: 'app',
})
// or
new Vue({
}).$mount('#app')

// Vue3
Vue.createApp({
}).mount('#app')
```


### dataプロパティ

- インスタンスを作成する際に、指定するオプションオブジェクトに`data`プロパティを付与することができる
- Vue2ではオブジェクトまたはオブジェクトを返す関数を指定できた
- Vue3ではオブジェクトを返す関数のみ指定することができる

```
// Vue2
new Vue({
    data: {
        message: 'this is Vue2'
    }
})

// Vue3
Vue.createApp({
    data: function() {
        return {
            message: 'this is Vue3'
        }
    }
}).mount('#app')
```


### transitionのclass名

- Vue2では`<transition>`を使用した際に、アニメーション初期のスタイルを定義するクラス名が`v-enter`、`v-leave`だった
- Vue3では`v-enter-from`、`v-leave-from`というクラス名に変更された

