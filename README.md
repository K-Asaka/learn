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


## イベントの伝播
イベントが目的の要素(ターゲット)に到達するまでの過程。

window  
↓↑  
document  
↓↑  
html  
↓↑  
body  
↓↑  
div  
↓↑  
div  
↓↑  
div … ターゲットフェーズ(イベントの発生元(要素)を特定)  

↓ … キャプチャフェーズ。最上位の window オブジェクトから下位の要素にイベントを伝播

↑ … バブリングフェーズ。下位の要素で発生したイベントを上位の要素に伝播


キャプチャフェーズでは最上位のwindowオブジェクトから文書ツリーをたどって、下位の要素にイベントが伝播する。そして、ターゲットフェーズでイベントの発生元(要素)を特定する。

バブリングフェーズは、イベントの発生元から上位の要素に向かって、イベントが伝播していくフェーズ。最終的に、最上位のwindowオブジェクトに到達したところで、イベントの伝播は終了。

**イベント処理はイベントの発生元だけで実行されるわけではない**

伝播の過程で、対応するハンドラが存在する場合は、それらも順に実行される。

## キーコードのエイリアス
* .enter
* .tab
* .delete(delete、Backspaceいずれにも対応)
* .esc
* .space
* .up
* .down
* .left
* .right

### KeyboardEvent.keyの値をケバブケース記法に変換

key値 | ケバブケース | キー
---|---|---
Escape | escape | Escキー
NumLock | num-lock | Num Lockキー
Backspace | backspace | Backspaceキー
Insert | insert | Insertキー
Delete | delete | Deleteキー
PrintScreen | print-screen | Print Screenキー
Home | home | homeキー
End | end | endキー
PageUp | page-up | Page Upキー
PageDown | page-down Page Downキー
ScrollLock | scroll-lock | Scroll Lockキー
AudioVolumeUp | audio-volume-up | 音量上昇キー
AudioVolumeDown | audio-volume-down | 音量減少キー

## Vue.jsアプリ開発を支援するブラウザ拡張「Vue.js devtools」

* Chrome拡張  
https://chrome.google.com/webstore/detail/vuejs-devtools/nhdogjmejiglipccpnnnanhbledajbpd

※ChromeでファイルシステムからVue.jsを実行する場合には、拡張機能の設定画面を開き、[ファイルのURLへのアクセスを許可する]を有効にする必要がある。

* Firefox拡張  
https://addons.mozilla.org/en-US/firefox/addon/vue-js-devtools/

## コンポーネント

### コンポーネントの定義

``` Vue.js
Vue.component(id, def)
```

id: コンポーネントの名前。ケバブケース記法かPascalケース記法。HTMLタグとの名前のバッティングに気をつける  
def: コンポーネントの定義情報。「オプション名: 値,...」形式のオブジェクトとして指定する

コンポーネントでは、Vueコンストラクタでは利用しなかったオプションも登場する。templateなどは、コンポーネントによって描画されるテンプレートを表す。テンプレート内では、これまでと同じく{{ ... }}構文やディレクティブも使えるが、**単一のルート要素をもたなければならない**点は注意。

以下のようなテンプレートはエラーとなる。

``` Vue.js
template: `
  <div>こんにちは、{{ name }}！</div>
  <div>こんばんは、{{ name }}！</div>
`,
```

この例であれば、複数の要素を<div>要素で束ね、ルート要素はひとつになるようにすればよい。

``` Vue.js
template: `<div>
  <div>こんにちは、{{ name }}！</div>
  <div>こんばんは、{{ name }}！</div>
</div>`,
```

### データオブジェクトの定義

Vueコンストラクタと同じく、内部データの管理はdataオプションで行う。ただし、**オブジェクトリテラルを返す関数**でなければならない。

### Pascalケース記法とケバブケース記法

componentメソッド側からPascalケース記法で名前を定義した場合、呼び出し側ではPascalケース記法、ケバブケース記法のどちらでも呼び出しが可能。一方、ケバブケース記法で定義された名前は、呼び出し側でもケバブケース記法でしか呼び出せない。

## プロパティ値の型を制限する

検証ルールは「ルール名: 値,...」形式のオブジェクトとして指定できる。ルール名として指定できるのは、以下の表のもの。

ルール名 | 概要
---|---
type | データ型(String, Number, Boolean, Function, Object, Array, Date, Symbolのいずれか)
required | プロパティが必須か
default | 値が指定されなかった場合の既定値
validator | カスタムの検証関数

### 検証ルールのさまざまな表現方法

#### (1) データ型だけを指定する

``` Vue.js
props: {
    // yourNameプロパティはString/Number型のいずれか
    yourName: [ String, Number ]
}
```

#### (2) 任意の型を検証する

typeオプションは、内部的にはinstanceof演算子で型を判定している。よってカスタムの型を指定できる。

``` Vue.js
props: {
    // userプロパティはUser型
    user: User
}
```

この場合、内部的には「user instanceof User」でプロパティ値が検証される。


#### (3) 既定値の指定方法に注意

文字列や数値、真偽型などの基本型については、defaultオプションに値を渡すだけ。以下の例で呼び出し側のyour-name属性を省略したときに「名無権兵衛」が適用される。

``` Vue.js
props: {
    yourName: {
        type: String,
        default: '名無権兵衛'
    }
}
```

ただし、既定値が配列やオブジェクトである場合は、値そのものではなく、以下のように既定値を返す関数を渡す。

``` Vue.js
props: {
    details: {
        type: Object,
        default: function () {
            return { value: 'Hoge' }
        }
    }
}
```

#### (4) 自作の検証ルールも指定できる

validatorオプションを利用することで、自作の検証ルールを指定することもできる。以下はyourNameプロパティが文字列で、文字数が5文字以内であることをチェックする。検証関数は、引数としてプロパティ値を受け取り、戻り値として検証の成否をtrueまたはfalseで返すようにする。

``` Vue.js
props: {
    yourName: {
        type: String,
        required: true,
        // 文字数が5文字以内であれば成功
        validator: function () {
            return value.length <= 5;
        }
    }
}
```

yourNameプロパティが5文字より大きい場合には、デベロッパーツールの[Console]タブに「Invalid prop: custom validator check failed for prop "yourName".」のようなエラーが表示される。

### 子コンポーネント->親コンポーネントの伝達

子コンポーネントでなんらかの処理を実行したときに、親コンポーネントに対して、「なんらかの変化が起こったこと」(イベント)を通知する。その際に、関連するデータ(任意のオブジェクト)を添付できる。

## コンポーネントの配下のコンテンツをテンプレートに反映させる

### スロットのスコープ

親テンプレートのすべては親コンポーネントが管理。子テンプレートのすべては子テンプレートが管理する。

### v-sotのさまざまな構文

#### (1) ディレクティブの動的引数

ディレクティブの動的引数は、v-slotディレクティブでも利用できる。以下はnameプロパティの値によって、埋め込み先のスロットを決定する。

``` Vue.js
<template v-slot:[name]>...</template>
```

#### (2) v-slotの省略構文

v-slotにも省略構文が用意されている。「#」で表記できる。

## コンポーネント(応用)

### 動的コンポーネント

<component>要素は「コンポーネントの入れ物」で、あらかじめ用意したコンポーネントをインポートし、動的な切り替えを可能にする。

### <keep-alive>要素の属性

#### (1) max属性

キャッシュするコンポーネントの最大数を指定する。キャッシュの個数が、この値を超えた場合、その時点で最近一番アクセスされていないコンポーネントから破棄される。

``` Vue.js
<keep-alive v-bind:max="5">...</keep-alive>
```

#### (2) include、exclude属性

キャッシュすべきコンポーネントをinclude属性で、キャッシュすべきでないコンポーネントをexclude属性で、文字列(カンマ区切り)、配列、正規表現のいずれかで指定する。

``` Vue.js
<keep-alive include="com1,com2">...</keep-alive>
<keep-alive v-bind:include="['com1', 'com2']">...</keep-alive>
<keep-alive v-bind:include="/com[12]/">...</keep-alive>>
```

## アニメーション

### アニメーションの対象は<transition>要素で宣言

アニメーションを有効にするには、対象の要素を<transition>要素でくくる。要素の直下は単一の要素でなければならない(単一要素トランジション)。

### アニメーションはスタイル定義で制御する

<transition>要素直下の要素には、次のタイミングでスタイルクラスが付与される。スタイルは、大きく「要素が追加(表示)されるとき」に付与されるEnterと、「要素が破棄(非表示)されるとき」に付与されるLeaveとに分類できる。

分類 | クラス | 概要
---|---|---
開始 | v-enter | enterの開始状態。要素が挿入される前(表示開始)
開始 | v-enter-to | enterの終了状態
最中 | v-enter-active | Enterトランジションのフェーズ中
最中 | v-leave-active | Leaveトランジションのフェーズ中
終了 | v-leave | leaveの開始状態(非表示開始)
終了 | v-leave-to | leaveの終了状態

### イージング

変化の度合いを表す情報。

設定値 | 概要
---|---
ease | 開始／終了を穏やかに
linear | 一定の変化
ease-in | 緩やかに開始
ease-out | 緩やかに終了
ease-in-out | 開始／終了を緩やかに(easeとほぼ同義)
cubic-bezier(x1,y1,x2,y2) | 制御点(x1,y1) (x2,y2)からできるベジェ曲線

#### ベジェ曲線

n個の制御点をもとに描かれるn-1次曲線。

### トランジションクラスを置き換える

トランジションクラスを置き換えるための属性

属性 | 既定のスタイル
---|---
enter-active-class | v-enter-active
enter-class | v-enter
enter-to-class | v-enter-to
leave-active-class | v-leave-active
leave-class | v-leave
leave-to-class | v-leave-to

### JavaScriptによるアニメーションの制御

<transition>要素が、次のイベント属性を提供している。
イベント属性で紐付いたイベントハンドラのことを、トランジションフックと言う。

属性 | 概要
---|---
before-enter | 要素が挿入される前
before-leave | 要素が非表示になる前
before-appear | 要素の初回描画の前
enter | 要素挿入後、アニメーション開始前
leave | before-leaveの後で、非表示アニメーション開始前
appear | 要素の初回描画時
after-enter | 要素が挿入された後
after-appear | 要素の初回描画の後
enter-cancelled | 要素の挿入をキャンセルしたとき
leave-cancelled | 要素の非表示をキャンセルしたとき(v-showのみ)
appear-cancelled | 要素の初回描画をキャンセルしたとき

### createElementメソッドの構文
```
createElement(name [,data] [,nodes])

name：要素名
data：データオブジェクト(指定できるオプションは以下の表の通り)
nodes：子要素(複数の場合は配列)
```

オプション | 概要
---|---
attrs | 属性 (class / style 以外)
class | class属性
style | style属性
props | コンポーネントのプロパティ
domProps | DOMプロパティ (textContentなど)
on | イベントハンドラ
nativeOn | イベントハンドラ (ブラウザネイティブ)

### JSX

大雑把に言えば、JavaScriptコードにHTMLを埋め込むためのしくみ。
temp_render.jsは以下のように表せる。

```
switch (this.type) {
    case 'text':
      return <p>...Now Loading...</p>;
    case 'image':
      return <img src="loading.gif" alt="loading" />;
    ...中略...
}
```

JSXはそのままHTMLではない。
最低限おさえておきたい制約は以下の通り。

* 空要素は「～ />」で終える
* 名前の異なる属性がある (class、for、tabindexなどはclassName、htmlFor、tabIndexで置き換え)
* コメント構文 &lt;!-- ～ --&gt;は利用できない
* JSXにJavaScriptの式を埋め込むには {...} でくくる
