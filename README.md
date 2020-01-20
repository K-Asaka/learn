# 学習記録用リポジトリ

## Vue.js

* 本番環境では```vue.min.js```を使う
* コードが意図した通り動かない場合は、ブラウザの開発ツールの[Console]タブでエラーの内容を確認する
* ```Cannot find element: #app```というエラーが出た場合は、```<dif id="app">```要素が認識できていない。```<script>```要素がページの末尾ではなく```<head>```要素などに書かれていないか確認する


## Vueクラス

Vueクラスをインスタンス化することで、Vue.jsを起動する(マウントするともいう)。  参照する用途がなければ、変数を省略してもいい。

```new Vue({...});```

コンストラクタにはVue.jsを動作させるためのオプションを```オプション名: 値, ...```のハッシュ形式で指定する。

hello.jsで利用しているのは以下のオプション。

* el : Vuejsを適用する要素
* data : データオブジェクト


## データオブジェクトにアクセスする

**Mustache(マスタッシュ)構文**　```{{...}}```　を使う。  
```{{...}}```で利用できるのは式だけ。
代入や条件分岐などを伴う文を指定することはできない。次のコードは実行できない。

```{{ let data = 13; }}```  
```{{ if (flag) { return data; } }}```


```{{...}}```で条件付き出力をしたい場合は、条件演算子を使う。

```{{ flag ? data: '0' }}```


## オフライン環境で利用する

Vue.jsダウンロード [ https://jp.vuejs.org/v2/guide/installation.html ]

```vue.min.js```をダウンロードし、任意のフォルダーに配置して、インポートして利用する。

### 障害時の備えに

```
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"</script>
<script>window.Vue || document.write('<script src="lib/vue.min.js"><\/script>');</script>
```
window.Vueが存在しない場合に、ローカルからライブラリをインポートする。

