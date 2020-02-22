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


## ディレクティブ

テンプレートを構成する仕組みは、まず以下2点をおさえておけばよい。

* {{...}} (Mustache構文)
* v-xxxxx属性 (ディレクティブ)

属性やスタイルの操作、条件分岐、繰り返し処理など、より複雑な機能を組み込みたい場合はディレクティブを利用する。
ディレクティブは「v-～」から始まる属性(構文)として表すのが基本。

```
<a v-bind:href="url" title="...">リンクです</a>
```

### 文字列をテンプレートに埋め込む

データオブジェクトにアクセスするのに、{{...}}の代わりに```v-text```ディレクティブを利用することもできる。

```
<div id="app">
    <p v-text="message"></p>
</div>
```

### {{...}}構文を無効化する

{{...}}に置かれた値を文字列として表示したい場合に、```v-pre```ディレクティブを利用する。

```
<div id="app">
    <p v-pre>{{ message }}</p>
</div>
```


### 属性値にJavaScript式を埋め込む

属性に対して式の値を埋め込むために{{...}}は利用できない。

```
<a href="{{ url }}">WINGSプロジェクト</a>
```
これは正しく動作しない。

属性値の操作には、代わりに```v-bind```ディレクティブを使う。

```
<div id="app">
    <a v-bind:href="url">WINGSプロジェクト</a>
</div>
```

```
new Vue({
    el: '#app',
    data: {
        url: 'https://wings.msn.to/'
    }
});
```

ディレクティブ名と属性名はコロン区切りで表記する。
v-bindはよく利用するという理由から、省略構文も用意されている。以下のようにしても同じ意味になる。

```
<a :href="url">サポートサイト</a>
```

## 算出プロパティとメソッドの相違点

* 算出プロパティは引数を持てない
* 算出プロパティは取得用途
* 算出プロパティの値はキャッシュされる


## ビューの非同期更新

リアクティブシステムによるページ(ビュー)の更新は非同期。  
Vue.jsでは、データの変更を検知しても、すぐにビューへ反映するわけではない。
連動して発生するすべての変更をプールしたうえで、最終的な結果をビューに反映させる

## ディレクティブ

標準的なHTMLに対して、ディレクティブと呼ばれる属性形式の命令を付与することで、ページに機能を付与する。
ディレクティブは「v-」で始まるのが基本。

| 分類 | 概要 | 主なディレクティブ |
|---|---|---|
| データバインド | 式の値をページに反映 | v-bind、v-htmlなど |
| イベント | イベント処理を実装 | v-on |
| フォーム | フォームからの入力を取得 | v-model |
| 制御 | 条件分岐や繰り返し処理など | v-if、v-forなど |

### Vue.jsで利用できる主なイベント

分類 | イベント名 | 概要
---|---|---
フォーム | focus | 要素にフォーカスが入ったとき
フォーム | blur | 要素からフォーカスが外れたとき
フォーム | change | 要素の値を変更したとき(input、select、textareaなど)
フォーム | select | テキストボックス/テキストエリアのテキストを選択したとき
フォーム | submit | フォームから送信したとき
マウス | click | 要素をクリックしたとき
マウス | dblclick | 要素をダブルクリックしたとき
マウス | mousedown | マウスのボタンを押したとき
マウス | mouseover | 要素にマウスポインターが乗ったとき
マウス | mouseenter | 要素にマウスポインターが乗ったとき
マウス | mouseleave | 要素からマウスポインターが外れたとき
マウス | mouseout | 要素からマウスポインターが外れたとき
マウス | mousemove | 要素の中をマウスポインターが移動したとき
マウス | mouseup | マウスのボタンを離したとき
キー | keydown | キーを押したとき
キー | keyup | キーを離したとき
キー | keypress | キーを押し続けているとき
その他 | resize | ウィンドウのサイズを変更したとき
その他 | scroll | ページや要素をスクロールしたとき
その他 | error | ページ内でエラーが発生したとき
その他 | contextmenu | コンテキストメニューを表示する前


## フォーム関連のディレクティブ
### 双方向データバインディング

データオブジェクト→テンプレートの片方向データバインディングと、そのデータ反映とテンプレート(一般的にはテキストボックスなどの入力)→データオブジェクトのデータ反映を可能にした双方向データバインディングがある。
双方向データバインディングとは、データオブジェクトとテンプレートの状態を同期するしくみと言い換えてもよい。


## より高度なイベント処理
### 定型的なイベント処理を宣言的に指定する

イベン既定の動作をキャンセルしたい、イベントのバブリングを停止したい、など、決まりきったコードを追い出し、本来のロジックに集中できるようにする。
そのような用途のためにVue.jsで用意しているのがイベント修飾子。
イベントに関わる定型的な処理を、属性の形式で表すための仕掛け。

```
v-on: イベント名.修飾子="..."
```

修飾子 | 概要
---|---
.stop | イベントの親要素への伝播を中止(stopPropagationメソッドに相当)
.prevent | イベント既定の動作をキャンセル(preventDefaultメソッドに相当)
.capture | イベントハンドラーをキャプチャモードで動作
.self | イベント発生元がその要素自身の場合にだけ実行
.once | イベントハンドラーを一度だけ実行
.passive | Passiveモードを有効化

### Passiveモード
Passiveモードとは、イベントハンドラーがpreventDefaultメソッドを呼び出さないことを宣言する。scrollイベントでPassiveモードを有効にすることで、ブラウザー(特にモバイル環境)ではイベントハンドラーの完了を待たずにスクロールを開始できるため、パフォーマンスの改善が期待できる。
その性質上、.passive修飾子と.prevent修飾子は同時に利用できない。

