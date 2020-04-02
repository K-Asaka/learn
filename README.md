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

### 関数型コンポーネント

出力はrenderオプション経由で行う。
関数型コンポーネントでは第2引数でコンテキストオブジェクトを受け取る。
コンテキストオブジェクトとは、コンポーネントの動作に必要とされる情報を詰め込んだオブジェクトのこと。
関数型コンポーネントでは、インスタンスを持たない(ということはthisにアクセスできない)ので、コンテキストオブジェクト経由で明示的に情報を受け取る必要がある。
コンテキストオブジェクトの主なプロパティは、以下のとおり。

プロパティ | 概要
---|---
data | createElementメソッドに渡されるデータオブジェクト
props | プロパティ情報
parent | 親コンポーネントへの参照
children | 子ノードの配列
slots | スロット情報
listeners | 親に登録されたイベントハンドラ

### ディレクティブの基本

ディレクティブを定義するのはVue.directiveメソッド。

```
directive(name, def)

name：ディレクティブの名前
def：動作の定義
```

ディレクティブの接頭辞「v-」は自動で付与される。
引数nameには除いた部分を指定する。
ディレクティブの動作は「どのタイミングで●○せよ」の形式で指定する。
引数defには「実行タイミング：関数」形式のオブジェクトを指定する。
利用できるタイミングには、以下の表のようなものがある。

実行タイミング | 概要
--- | ---
bind | ディレクティブが要素に紐付いたときに一度だけ
inserted | 要素が親ノードに挿入されたとき
update | 上位のコンポーネントが更新されるとき
componentUpdated | 配下のコンポーネントが更新された時
unbind | ディレクティブが要素から除去されたときに一度だけ

これらのタイミングで実行される関数をフック関数と呼ぶ。
ディレクティブの挙動を初期化するならば、まずはbindを利用すれば良い。

フック関数が受け取る引数の意味は、次の表の通り。

引数 | 概要
--- | ---
el | ディレクティブが適用された要素
binding | バインド情報オブジェクト (具体的なプロパティは以下)
vnode | 現在の仮想ノード
oldVnode | 変更前の仮想ノード (update / componentUpdatedでのみ利用可)

bindingプロパティ
プロパティ | 概要
--- | ---
name | ディレクティブの名前(接頭辞「v-」を除いたもの)
value | ディレクティブに渡された値(「v-mydir="2 + 3"」ならば「5」)
oldValue | 変更前の値(update / componentUpdatedでのみ利用可)
expression | 文字列としてのバインド式(「v-mydir="2 + 3"」ならば「2 + 3」)
arg | 引数(「v-mydir:hoge」」ならば「hoge」)
modifiers | 修飾子(「v-mydir.hoge.piyo」ならば{ hoge: true, piyo: true })

## Vue CLI

アプリの骨格を自動生成するコマンドラインツール。

### Vue CLIのインストール

Node.js 8.10.0以降が必要。　本家サイト(https://nodejs.org/ja/)

```
> npm install -g @vue/cli
```

以前のバージョンをインストールしている場合、Vue CLIは、バージョン2.xから3.xでパッケージ名が変更になっている。もしVue CLI 2.xがインストールされている場合は、3.xをインストールする前に、アンインストールしておく必要がある。
```
> npm uninstall -g vue-cli
```

### プロジェクトの自動生成

#### [1] プロジェクトを作成する

Vue CLIはアプリをひとつのフォルダ配下で管理する。
このフォルダ配下で管理されるファイル群のことをプロジェクトと呼ぶ。
プロジェクトを作成するには、`vue create`コマンドを実行する。

オプション | 概要
--- | ---
-p name | 指定の設定名 name を利用
-d | 既定の設定を利用
-f | フォルダが存在する場合、強制的に上書き
-n | Gitを無効化
-x | プロジェクト作成時にプロキシを利用

`C:\data`フォルダに、`my-cli`という名前でアプリを作成する例
```
cd c:\data
vue create my-cli

Vue CLI v3.6.2
? Please pick a preset:
> default (babel, eslint)
  Manually select features
```

利用するプリセットを訊かれる。既定(default)か、カスタム(Manually)を↑↓で選択する。既定のプリセットで先にすすめる。既定では、

* Babel:ES20XXコードを(一般的には)ES5相当のコードに変換するトランスコンパイラー
* ESLint:「べからず」なコードを検出するためのツール(Lint)

が有効になっている。
「default～」が選択されていることを確認して、Enterキーを押す。
既定(標準)インストールの場合は、これだけで準備は完了。

#### [2] プロジェクトの中身を確認する

`C:\data\my-cli`フォルダの配下に生成されるフォルダとファイル。

my-cli(プロジェクトルート)
├─ node_modules(インストールされたライブラリ一式)
├─ public
│    ├─ index.html (トップページ)
│    └─ favicon.ico (ファビコン)
├─ src （ソースコード)
│   ├─ assets (画像などのアセット一式)
│   │    └─ logo.png (ロゴ画像)
│   ├─ components (コンポーネント一式)
│   │    └─ HelloWorld.vue (HelloWorldコンポーネント)
│   ├─ App.vue (メインコンポーネント)
│   └─ main.js (エントリースクリプト)
├─ .gitignore (Gitの管理から外すための設定ファイル)
├─ babel.config.js (babelの設定ファイル)
├─ package.json (npmの設定ファイル)
├─ package-lock.json (ライブラリ間の依存関係を管理)
└─ README.md (ReadMeファイル)

#### [3] アプリを実行する

```
cd my-cli
npm run server
```

ブラウザーを起動し、`http://localhost:8080`でアクセスする。
停止は`Ctrl+C`。

#### 補足:プロジェクトをビルドする

`npm run build`コマンドで、アプリをビルドし、本番環境に配置(デプロイ)するためのファイル一式を作成する。
ビルドに成功すると、プロジェクトルートの直下に`/dist`フォルダが生成される。
後は、配下のフォルダとファイル一式を、HTTPサーバーに配置すればアプリを実行できる。

### Vue CLIの主なサブコマンド

#### プラグインを追加する ～ vue add コマンド

プロジェクト作成時のウィザードで組み込む他、`vue add`コマンドで後からプロジェクトに組み込むことも可能。

単体テストのためのJestを組み込む例。

```
vue add @vue/unit-jest
```

接頭辞として`@vue/`がない場合は、サードパーティのプラグインであるとみなされる。以下は、Elementのプラグインを導入する例。

```
vue add element
```

正確にはプラグインではないが、Vue Router、Vuesのようなライブラリも追加できる。

```
vue add router
vue add vuex
```

#### .vueファイルを素早く実行する ～ vue serve コマンド

`vue serve`を実行すると、.vueファイルをプロジェクトを作成することなく実行できる。`vue serve`コマンドを利用するには、`@vue/cli`に加えて、以下のアドオンをインストールしておく必要がある。

```
npm install -g @vue/cli-service-global
```

App.vueを実行する場合
```
cd project_root
vue serve
```

`npm run serve`を実行した場合と同じく開発サーバーが起動する。
ブラウザで`http://localhost:808`にアクセスする。

オプション | 概要
--- | ---
-o | 自動でブラウザーを起動
-c | クリップボードに起動URLをコピー

ファイル名を明記することで、異なるファイルをエントリーポイント(開始地点)にすることもできる。

```
vue serve MyHello.vue
```

#### Vue CLIプロジェクトをGUI管理する ～ vue ui コマンド

Vue CLI 3.xから搭載されたVueプロジェクトマネージャー。
ブラウザ上で動作するプロジェクト管理ツール。
以下の機能を提供する。

* プロジェクトの作成
* ダッシュボード(プラグインの更新やニュースフィードなどを表示)
* プラグインの管理(追加、削除、検索)
* 依存の管理(ライブラリのインストールやインストール済みライブラリの確認)
* プロジェクトの設定(ベースURL、出力ディレクトリなど各種設定)
* タスク管理(serve、build、link、inspect)

以下のコマンドで起動する。

```
vue ui
```

### 単一ファイルコンポーネント

コンポーネントを構成するテンプレート、スタイル、ロジックをひとつのファイル(.vueファイル)としてまとめたもの。
**Single File Component**の頭文字からSFCと呼ばれることもある。


### Vue.jsの基本設定を定義

`Vue.config.設定名 = 値`で定義できる。

プロパティ | 概要
--- | ---
silent | trueでVue.jsによるエラー／警告を非表示(既定はfalse)
optionMergeStrategies | カスタムオプションのマージルール
devtools | Vue.js devtoolsとの連携を有効にするか
errorHandler | 補足されなかったエラーの処理方法
warnHandler | 実行時警告に対する処理方法
ignoredElements | 無視すべきコンポーネントの名前(文字列／または正規表現の配列)W
keyCodes | v-onで利用できるキーコードのカスタムエイリアス
performance | ブラウザの開発者ツールでパフォーマンス追跡を有効にするか(既定はfalse)
productionTip | 起動時ヒントを表示するか(既定はtrue)

### 匿名関数をより簡単に表現する

アロー関数を利用することで、匿名関数(関数リテラル)をよりシンプルに表現できる。

従来の関数構文
```
render: function(h) {
    return h(App);
},
```

アロー関数で書き換える
```
render: (h) => {
    return h(App);
},
```

関数の本体が一文の場合、`{ ... }`は除去できる。また、アロー関数では式の値がそのまま関数の戻り値となるので、returnも不要。
```
render: (h) => h(App),
```

引数が1個の場合は、引数をくくる丸カッコも省略できる。
```
render: h => h(App),
```

#### thisの落とし穴

Vueインスタンスのは以下では、ライフサイクルフック、イベントハンドラー、ウォッチャーなどで、関数リテラルを利用しているが、これらでデータオブジェクトにアクセスしているならば(thisにアクセスしているならば)、アロー関数を利用してはいけない。
もしもこのような文脈で関数(メソッド)の記述を簡単化するならば、ES2015で書かれたメソッドの簡易構文を利用する。以下は同じ意味(アロー関数のようにthisが固定されることはない)

```
methods: {
    onclick: function (e) { ... },
}
-----
methods: {
    onclick(e) { ... },
}
```

### TypeScript

#### TypeScriptの導入

Vue CLIを利用している場合、プロジェクト作成時に`[Manually select features]`(カスタムインストール)を選択することで、TypeScript利用のためのコンパイラから設定、テンプレートを組み込むことが可能。
カスタムインストール時に`TypeScript`を選択することで利用することが可能になる。

#### TypeScriptプロジェクトのフォルダ構造

root(プロジェクトフォルダ)
├─ src
│   ├─ components
│   │    └─ HelloWorld.vue (HelloWorldコンポーネント)
│   ├─ App.vue (Appコンポーネント)
│   ├─ main.ts (起動スクリプト)
│   ├─ shims-txs.d.ts (型定義ファイル)
│   └─ shims-vue.d.ts (型定義ファイル (.vueファイル))
├─ tsconfig.json (TypeScriptの設定ファイル)
└─ tslint.json (TSLintの設定ファイル)


tsconfig.jsonで書かれている設定内容

* compilerOptionsオプション：コンパイラの動作オプション
サブオプション | 概要
--- | ---
target | JavaScriptのバージョン(es5、es2015～2017、esnext)
module | JavaScriptモジュールの形式(none、commonjs、amd、system、umd、es2015、esnext)
strict | すべての厳密な型チェックオプションを有効にするか
jsx | JSXのモード(React、Preserve)
moduleResolution | モジュールの解決方法(none、classic)
experimentalDecorators | デコレーターを有効にするか
allowSyntheticDefaultImports | default export無しでもdefault importを許可するか
sourceMap | ソースマップを作成するか
baseUrl | 非相対パスの基準となる場所
types | コンパイラに含める宣言ファイルのリスト
paths | モジュールのパス
lib | コンパイルに含めるライブラリ

* includeオプション：コンパイル対象となるファイルパターン
* excludeオプション：コンパイル対象から除外するファイルパターン


## ルーティング

### ルーティングとは

SPAではページの切り替えもアプリの責務。
ページ切り替えのライブラリとして、Vue.jsが公式で提供しているのがVue Router。

ルーティングとは、クライアントから要求されたURLに応じて、処理の受け渡し先(コンポーネント)を決定すること、あるいは、その仕組のことを言う。

Vue Routerは、あらかじめ用意しておいた振り分け情報(ルーティングテーブル)に基づいて、対応するコンポーネントを呼び出し、その処理結果をページに反映させるところまでを担う。ルーティングに際して、ブラウザの履歴もまとめて管理する。非SPAなアプリと同じ感覚でSPAアプリを利用できる。

#### Vue Routerの準備

Vue CLIを利用する場合、プロジェクト作成時に[Manually select features](カスタムインストール)を選択してRouterを有効にするか、後から`vue add`コマンドでRouterを組み込む必要がある。

カスタムインストールでRouterを有効にした場合、ウィザードでhistoryモードの設定が追加される。
historyモードとは、History API(history.pushStateメソッド)を利用したページ遷移のモード。無効にした場合は、hash(hashbang)モードが利用される。

具体的には

* historyモードでは`http://localhost:8080/about`
* hashモードでは`http://localhost:8080/#/about`

のようなアドレスが生成される。
Vue Routerを有効にすると、プロジェクトには以下のフォルダ／ファイルが追加される。

root(プロジェクトフォルダ)
└─ src
    ├─ components
    │    └─ HelloWorld.vue (HelloWorldコンポーネント)
    ├─ views
    │    ├─ About.vue (Aboutコンポーネント)
    │    └─ Home.vue (Homeコンポーネント)
    ├─ App.vue (Appコンポーネント)
    ├─ main.ts (起動スクリプト)
    └─ router.js (ルーティング定義ファイル)

ルーティングに関わるコンポーネントは`/views`フォルダに、より細かな部品は`/components`フォルダに、それぞれ格納するのが慣例。
小規模なアプリならば、`/components`にまとめても良い。

#### ルーティング情報の定義

ルータを利用するには、Routerオブジェクトを生成する。
どのURLに対して、どのコンポーネントを紐付けるかを準備しておく必要がある。
ルーティング設定を表すのは、/src/router.jsの役割。

```router.js
import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

// Vue Routerを有効化
Vue.use(Router)

// Routerオブジェクト
export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    // ルーティングテーブルを定義
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/about',
            name: 'about',
            component: () => import('./views/About.vue')
        }
    ]
})
```

ルータコンストラクタの主なオプション
オプション | 概要 | 既定値
--- | --- | ---
mode | 動作モード(hash | history) | hash
routes | ルーティング情報 | -
base | アプリの基底URL | /
fallback | ブラウザがHistory APIに未対応の場合、hashモードにフォールバックするか | true
linkActiveClass | 現在ページを表すリンクに適用されるスタイルクラス | router-link-active
linkExactActiveClass | 完全一致な現在ページを表すリンクに適用されるスタイルクラス | router-link-exact-active
scrollBehavior | ページ移動時のスクロールの方法 | -

ひとつのオブジェクトがひとつのルートを表し、その集合(オブジェクト配列)でルーティングテーブルを表現する。ルートオブジェクトで利用できるプロパティには以下のようなものがある。

プロパティ | 概要
--- | ---
base | アプリの基底パス(既定は「/」)
path | リクエストパス
name | コンポーネントの名前
component | ルーティングによって呼び出されるコンポーネント
components | ルーティングによって呼び出されるコンポーネント(複数)
redirect | リダイレクト先のパス
children | 配下のルート定義
props | ルートパラメーターをプロパティに割り当てるか
alias | エイリアス
meta | ルートのメタ情報(「キー名:値,...」形式)
caseSensitive | 大文字小文字を無視するか

pathやcomponentの組み合わせで「/～にアクセスしたら、、xxxxコンポーネントを呼び出す」のように表すのが最低限の構成。
先にあげたソースコードでは、次のようなルートを定義したことになる。

* 「/」でHomeコンポーネントを呼び出す(実体はHome.vue)
* 「/about」でAboutコンポーネントを呼び出す(実体はAbout.vue)

いずれの.vueファイルも、既定では/src/viewsフォルダに用意されている。ルート定義に利用するコンポーネントは、`import コンポーネント名 from './views/ファイル名'`形式であらかじめインポートしておく。

#### コンポーネントの非同期ロード

Vue CLIの既定の設定では、すべてのコードはapp.jsにバンドルされたうえで実行される。しかし、アプリの規模が大きくなれば、.jsファイルも肥大化し、比例して起動時間も増加する。そこで、巨大なコンポーネント、そもそもアクセス頻度の低いコンポーネントは、非同期ロードさせるようにすることで、app.jsから分割し、必要になったところでロードできるようになる。
非同期ロードをしているコードは以下の部分。

`component: () => import('./views/About.vue')`

componentオプションに、コンポーネントを取得するための関数を渡す。
import命令そのものを渡すのではなく、import命令を呼び出すための関数である点に注意。

#### ルートの有効化

定義されたルートは、/src/main.jsでVueインスタンスに紐付けられている。

```main.js
import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

new VUe({
    router,
    render: h => h(App)
}).$mount('#app')
```

`router,`は`router: router,`としても同じ。
プロパティ名と値とが同じ場合には、このような省略表記が可能。

### メインコンポーネント(App.vuew)

ルーティングによる表示領域、画面遷移の方法を見ていく。

```App.vue
<template>
    <div id="app">
        <div id="nav">
            <router-link to="/">Home</router-link>
            <router-link to="/about">About</router-link>
        </div>
        <router-view />
    </div>
</template>
```

ルータ経由でページを遷移する場合には、標準的なアンカータグ(`<a>`)の代わりに、`<router-link>`要素を利用する。
v-bindディレクティブ経由で、文字列、オブジェクトとして移動先の情報を渡すこともできる。
以下はすべて同じ意味。

```
<router-link to="/about">About</router-link>
<router-link v-bind:to="'/about'">About</router-link>
<router-link v-bind:to="{ path: '/about' }">About</router-link>
<router-link v-bind:to="{ name: 'about' }">About</router-link>
```

最後のnameプロパティは、ルーティング情報で定義されたコンポーネント名。Vue Routerでは、このように名前で移動先を表すこともできる。これを**名前付きルート**という。
ルータ経由で呼び出されたコンポーネントは、<router-link>要素で確保された領域に反映される。ルーティングを利用するには、router-viewによる表示領域の宣言は必須。

#### オブジェクトで指定できるプロパティ

オブジェクト形式で移動先のパスを指定する場合、pathやnameの他にも、以下のようなパラメータ情報を指定できる。

* params：ルートパラメータ
* query：クエリ情報

#### プログラムからページ遷移

標準的なJavaScriptであれば`location.href`プロパティなどを利用する。
しかし、これはページ全体を差し替える命令のため、ルータ環境では使えない。
ルータ経由でのページの移動には、`$router.push`メソッドを利用する。
次のコードの場合、ボタンクリック時に「/」(トップ画面)に移動する例。

```About.vue
<template>
    <div class="about">
        ...中略...
        <button v-on:click="onclick">トップ</button>
    </div>
</template>

<script>
export default {
    methods: {
        // ボタンクリックで「/」に移動
        onclick(): {
            this.$router.push('/')
        }
    }
}
</script>
```
<router-link>要素に対する場合と同じく、pushメソッドにもオブジェクトを引き渡せる。

### ルータ経由で情報を渡す方法

#### パスの一部をパラメータとして引き渡す ～ルートパラメータ

たとえば「～/article/108」「～/books/978-4-7981-5757-3」のようなパスで、コンポーネントに対して「108」「978-4-7981-5757-3」のような値を引き渡すことができる。
パラメータ値をパスの一部として表現できるため、視認性にも優れ、ルータ経由での値の引き渡しとしては、よく利用されるアプローチ。このようなパラメータのことをルートパラメータと言う。

##### [1] ルートを追加する

```router.js
import Article from './components/Article.vue'
...中略...
export default new Router({
    ...中略...
    routes: [
        ...中略...
        // :aidパラメータを受け取るArticleルート
        {
            path: '/article/:aid',
            name: 'article',
            component: Article
        }
    ]
})
```

ポイントとなるのは、pathパラメータに含まれた「:名前」の表記。
これはパラメータの置き場所(プレイスホルダー)で、「:名前」の部分に「～/article/108」「～/article/1」のように、任意の値を埋め込めることを意味する。
ここでは、:aidパラメータをひとつだけ配置しているが、「/blog/:year/:month/:day」のように、複数のパラメータを埋め込むことも可能。

##### [2] ルートパラメータを受け取る

```Article.vue
<template>
    <span>記事コード:{{ $route.params.aid}}</span>
</template>
```

ルートパラメータは`this.$route.param.パラメータ`で参照できる(テンプレート内であれば、単に`$route.params.パラメータ`)。

##### [3] リンク文字列を生成する

Appコンポーネントからのリンクの用意。
```App.vue
<template>
    <div id="app">
        <div id="nav">
            <router-link to="/">Home</router-link>
            <router-link to="/about">About</router-link>
            <router-link to="/article/108">記事:No.108</router-link>
        </div>
        <router-view>
    </div>
</template>
```

#### $routeオブジェクトで取得できる情報

プロパティ | 概要
--- | ---
name | ルート名
fullPath | クエリ／ハッシュを含んだ完全なパス(例:/article/108#main?num=1)
path | ルートのパス
query | クエリ情報(?～以降の情報)。「キー名:値,...」形式
hash | ハッシュ(#～以降の文字列)
matched | すべてのルート情報(ネストまで含む)
redirectFrom | リダイレクト元の名前


##### クエリ情報、ハッシュ

ルートで明示的に宣言しなくてもよい分、クエリ情報、ハッシュは手軽な情報受け渡しの手段に見える。しかし、ルート経由で受け渡しする情報があいまいになり、なにより独自の記法である分、ルートパラメータに比べるとパスは読みにくくなる。
SMO(Social Media Optimization)などの観点から、それ自体が意味を持った、ユーザーにとって視認しやすいURLが好まれる傾向にある。

### ルートパラメータのさまざまな表現

#### 任意のパラメータ

パラメータの末尾に`?`で表す。

`/article/:aid?`

このルートは、

* /article      (undefined)
* /article/108  (108)

のようなパスにマッチする(カッコ内はaidの値)。
パラメータ値がundefinedになる可能性があるため、一般的にはコンポーネント側でなんらかの規定値を用意すべき。

#### 可変長のパラメータ

パラメータの末尾に`*`を付与することで、`/`をまたいで残りのパスをすべて取得できる。

`/article/:aid*`

このルートは、

* /article              (undefined)
* /article/108          (108)
* /article/vue/router   (vue/router)

のようなパスにマッチする。複数値はそのまま`/`区切りで返される。
値を分割するのはコンポーネント側の役割。
`*`は正しくは「0個以上の値にマッチ」(=値を省略できる)。もしも最低限一つ以上の値を持たせたい場合には`+`を利用する。

`/article/:aid+`

このルートは`/article/108`、`/article/vue/router`にはマッチするが、`/article`にはマッチしない。

##### 可変長パラメータの注意点

可変長パラメータは、パスの末尾で利用する。
そうでなくてもエラーにはならないが、パラメータの振り分けがあいまいになる。
以下、可変長パラメータを末尾にしなかった場合の例と、パラメータへの反映結果をまとめたもの。

ルート | :aid | :num
--- | --- | ---
/article/:aid*/:num | 108 | 10
/article/:aid*/:num? | 108/10 | undefined
/article/:aid*/:num* | 108/10 | undefined
/article/:aid*/:num+ | 108 | 10

後続のパラメータによって、可変長パラメータへの反映のされ方も変化する。
予測できないほどではないが、誤解を招きやすいルートを好んで利用すべきではない。

#### 値の形式をチェック

パラメータの末尾に`(...)`の形式で、正規表現を付与することもできる。その場合、正規表現に合致した値だけがマッチする。

`/article/:aid(\\d{2,3})`

`\d{2,3}`は2～3桁の数値を表す。
このルートは、

* /article/10   (10)
* /article/108  (108)

にはマッチするが、以下のようなパスにはマッチしない。

* /article/vue  (文字列なので不可)
* /article/1    (1桁なので不可)

##### ルートの優先順位

ルートパラメータを利用するようになると、ルートそのものの優先順位も意識しておく必要がある。ルートは定義順に判定され、最初にマッチした条件でルートが決定する。
たとえば以下のようなルートが列記されている場合。

1./:type/:grade
2./books/:isbn

この場合、`/books/978-4-7981-5757-3`のようなリクエストは、最初に定義されたルート1.にマッチし(:type=books、:grade=978-4-7981-5757-3)、2.へはマッチングを試みることすらない。
このことから、ルートを定義する際には、特殊なルートを先に、一般的なルートを後に記述する。

### ルートパラメータをプロパティとして受け渡す

パラメータを$routeオブジェクト経由で受け渡し宇sるのは、あまり良いことではない。
コンポーネントが特定のルート経由で呼び出される前提となり再利用性を損なう。
一般的には、パラメータはプロパティ(props)経由で受け渡しする。
以下のようにコードを書き換える。

```rouer.js
routes: [
    ...中略...
    {
        path: '/article/:aid',
        name: 'article'
        component: Article,
        props: true,
    }
]
```

```Article.vue
<template>
    <span>記事コード: {{ aid }}</span>
</template>

<script>
export default {
    name: 'Article',
    props: {
        aid: String
    }
}
</script>
```

ルートパラメータをコンポーネントのプロパティに引き渡すには、ルーティング定義にpropsオプション(値はtrue)を追加するだけ。これでpathオプションで定義されたルートパラメータが、そのままプロパティに引き継がれる。
Articleコンポーネント側ではプロパティを定義しておく。これでテンプレート側でも($route.params.aidではなく)aidだけでアクセスできる。

##### パラメータの型変換

`props: true`オプションは、ルートパラメータをそのままプロパティに引き渡すだけ。たとえば、ArticleコンポーネントがaidプロパティをNumberとして受け取る場合、`type check failed for prop "adi".`のようなエラーとなる。`$route.params`の戻り値は文字列であるため。
このような場合には、型を変換しておく。

```router.js
{
    path: '/article/:aid',
    ...中略...
    props: routes => ({
        aid: Number(routes.params.aid)
    })
},
```

propsオプションに変換ルール(=関数)を渡す。変換関数のルールは以下2点。

* 引数として$routeオブジェクトを受け取る
* 戻り値として、プロパティ情報を「名前: 値, ...」形式のオブジェクトとして返す

戻り値全体を丸カッコでくくっているのは、アロー関数ではオブジェクトリテラルを表す`{...}`が、関数ブロックと誤認識されてしまうから。丸カッコによって、リテラルであることを明示する。
また、この例では型変換に利用しているが、関数構文を利用すれば、一般的な値の変換や加工に利用できる。また、クエリ情報やハッシュなどの値をプロパティに割り当てることも可能。固定値をプロパティに引き渡しても構わない。

##### propsオプションにオブジェクトを渡す
値の演算が不要なのであれば、propsオプションに(関数ではなく)オブジェクトリテラルを直接渡すこともできる。固定値でプロパティを指定するならば、関数形式よりもシンプルに表現できる。

`props: { aid: 108 }`


### マルチビュー、入れ子のビュー、ガードなど

#### 複数のビュー領域を設置する

Vue Routerでは、テンプレートに複数の`<router-view>`要素を配置することで、複数のビューを同時に配置できる。ただし、個々のビューを区別するために、それぞれの領域に任意の名前(name属性)を付ける必要がある。

```App.vue
<template>
    <div id="app">
        <img src="./assets/logo.png">
        <router-view>
        <hr>
        <router-view name="sub">
    </div>
</template>
```

また、ルート定義も、複数の領域にコンポーネントを割り当てられるよう、componentsパラメータ(複数形)で表す。

```router.js
export default new Router({
...中略...
    routes: [
        {
            path: '/',
            name: 'main',
            components: {
                default: Main,
                sub: Article
            }
        }
    ]
})
```

componentsパラメータは「領域名: コンポーネント」の形式で指定する。defaultは、`<router-view>`要素にname属性を指定しなかった場合の、既定の領域名。

#### 入れ子のビューを設置する

Vue Routerでは、ビュー同士を入れ子に配置することもできる。
たとえば「/article/108」で記事のリード文を表示し、「/article/108/pages/1」「/article/108/pages/2」のようにすることで、それぞれ各ページの内容を表示するといったケース。
このようなルートを想定しているのが、以下のルーティング定義。

```router.js
export default new Router({
...中略...
    routes: [
        {
            path: '/article/:aid',
            name: 'article',
            component: Article,
            props: true,
            children: [
                {
                    path: 'pages/:page_num',
                    name: 'page',
                    component: Page,
                    props: true,
                }
            ]
        }
    ]
});
```

ルートの入れ子はchildrenパラメータで表す。この例であれば、「/article/:aid」ルート配下に子ルート「pages/:page_num」が連なり、「/article/:aid/pages/:page_num」のようなパスが生成される。
children(複数形)となっていることからもわかるように、子ルートは複数列記することも可能。ルートの準備ができたら、配下のArticleやPageコンポーネントも確認しておく。

```Article.vue
<template>
<div>
    <div>記事コード: {{ aid }}</div>
    <span><router-link v-bind:to="'/article/' + aid + '/pages/1'">Page: 1</router-link></span> |
    <span><router-link v-bind:to="'/article/' + aid + '/pages/2'">Page: 2</router-link></span>
    <hr>
    <router-view>
</div>
</template>

<script>
export default {
    name: 'Article',
    props: {
        aid: String
    }
}
</script>
```

```Page.vue
<template>
    <div>{{ page_num }} ページ</div>
</template>

<script>
export default {
    props: {
        page_num: String
    }
}
</script>
```

ルートを入れ子にする場合、親テンプレートの側でも子コンポーネントを埋め込むための領域を、`<router-view>`要素で確保しておかなければならない。
なお、「/article/108」のようなパスでアクセスした場合には、Page.vueの内容は表示されない。「pages/:page_num」にはマッチしていないからである。

### ルート遷移時に処理を差し挟む ～ ナビゲーションガード

ルーティングに際して、たとえばユーザーの権限を判定して、決められた権限を持たない場合にはガードしたい、といった状況がある。このように画面遷移時に処理を挟むためのしくみがある。**ナビゲーションガード**機能である。
Vue Routerでは、それぞれの目的に応じて、以下のようなガードを用意している。

分類 | ガード | 概要
--- | --- | ---
グローバル | beforeEach | すべてのルートへの移動前／コンポーネントガード処理前
グローバル | beforeResolve | すべてのルートへの移動前／コンポーネントガード処理後
グローバル | afterEach | すべてのルートへの移動後
コンポーネント | beforeRouteEnter | コンポーネントへの移動前
コンポーネント | beforeRouteUpdate | コンポーネント上でルート情報が変化したとき
コンポーネント | beforeRouteLeave | コンポーネントから移動する前
ルート | beforeEnter | ルートへの移動前

グローバルガードはVueRouterインスタンスに対して、コンポーネントガードはコンポーネントに対して、ルートガードはルート定義に対して、それぞれ宣言する。

```
const router = new Router({ ... })
router.beforeEach((to, from, next) => { ... })  // グローバルガード(router.js)
export default router
```

```
export default {
    template: `...`,
    beforeRouteEnter(to, from, next) { ... }    // コンポーネントガード(.vue)
}
```

```
const router = new Router({
    routes: [
        {
            path: 'hoge',
            component: hoge,
            beforeEnter: (to, from, next) => { ... }    // ルートガード(router.js)
        }
    ], ...
})
```

違いは宣言する位置だけで、用法はほぼ共通しているので、以降ではコンポーネントガードを例にする。以下は、Articleコンポーネントに対して、指定の記事が公開期限を過ぎていたら、アクセスをガードするサンプル。公開期限は「aid値: 期限, ...」形式のオブジェクトで管理しているものとする。

#### [1] コンポーネントガードを実装する

まず、コンポーネントガード本体を定義する。

```Article.vue
<template>
    <div class="about">
        <h1>記事コード: {{ aid }}</h1>
    </div>
</template>

<script>
// ナビゲーションガードを定義
let timeGuard = function (to, from, next) {
    // 有効期限を設定
    let data = {
        13: new Date(2019, 10, 30),
        108: new Date(2018, 10, 30)
    }

    // 移動先のaid値から有効期限を取得
    let limit = data[to.params.aid] ? data[to.params.aid] : new Date(2999, 12, 31)

    // 現在日時
    let current = new Date()
    // 有効期限内であればそのまま記事を表示
    if (limit && limit.getTime() > current.getTime()) {
        next()
        // さもなくば移動をキャンセル
    } else {
        window.alert('記事の公開期限が過ぎています。')
        next(false)
    }
}

export default {
    name: 'ArticleU,
    // ナビゲーションガードを紐付け
    beforeRouteEnter: timeGuard,
    beforeRouteUpdate: timeGuard,
    props: {
        aid: String
    }
}
</script>
```

コンポーネントガードは、コンポーネント定義の中で宣言する。
ここで、`beforeRouteEnter`や`beforeRouteUpdate`双方に同じガードを紐付けている点に注目する。`beforeRouteEnter`だけでは不十分。
`beforeRouteEnter`はコンポーネントそのものが変化したときにだけ発生する。つまり、/article/13から/artile/108のようなルートパラメータだけの変化を検知できない。ルート情報の変化を検知するには、beforeRouteUpdateを利用する。ただし、`beforeRouteUpdate`だけでは、今度はコンポーネントの移動を検知できないため、双方のガードを宣言している。

例のコンポーネントガードの引数
引数 | 概要
--- | ---
to | 移動先のルート情報
from | 移動前のルート情報
next | ナビゲーションのためのコールバック関数

ルート情報は$routeと等価。ここでは、aidパラメータをキーに、記事の公開期限を取得＆判定している。
ガードでは、判定の結果、ナビゲーション(ルート移動)を進めてよいかどうかをnext関数で支持する(戻り値はない)。next呼び出しのパターンには、以下のようなものがある。

```
next()                                  // 移動を許可
next(false)                             // 移動をキャンセル
next('/')                               // 指定のパスに振り替え
next({ path: '/' })                     // 指定のパスに振り替え(オブジェクト形式)
next(new Error('Error is occured.'))    // エラーを発生
```

ルートの移動をそのまま進めてよい場合には、引数なしでnext関数を呼び出す。正常パターン。
ルート移動をキャンセルし、現在のルートにとどまるならば、falseを渡す。
強制的に異なるパスに振り分けたいならば、引数にパスを指定する。パスは、文字列、オブジェクトいずれの形式で指定しても構わない。
エラーを発生させると、移動時エラーをルーターに通知する。ここで投げられたエラー情報はVueRouter#onErrorメソッドで受け、処理することが可能。

```
const router = new Router({ .... })
// エラー情報をログに出力
router.onError(err => console.log('Error::' + str.message))
export default router
```

#### ルーターによるリンクの制御

`<router-link>`要素は、to属性以外にも、さまざまな属性を提供しており、ルーティング時の制御を細かく実装できる。

##### active-class属性

リンク先が現在のアドレスと同じである場合に、適用されるスタイルクラス(アクティブスタイル)を指定する。スタイルそのものは`<style>`要素などであらかじめ準備しておく。規定値は、`router-link-active`。

```App.vue
<router-link to="/about" active-class="current">About</router-link>

.current {
    color: red;
    font-weight: bold;
}
```

アクティブスタイルは、RouterクラスのlinkActiveClassオプションでグローバルに設定できるため、一般的にはこちらでアプリ全体の設定を、リンク固有のスタイルを指定したい場合にだけactive-class属性を利用する。

##### exact属性
active-class属性の既定の適用ルールは、前方一致。よって、/hogeというリンクは/hogeはもちろん、/hoge/123、/hoge/aboutなどにもマッチし、アクティブスタイルを適用する。
ただし、この挙動が望ましくない場合がある。

`<router-link to="/">Home</router-link>`

「/」は「/about」「/hoge」「/hoge/foo」など、すべてのパスにマッチする。このような状態は一般的には望ましくない。exact属性を指定する。
以下のように設定することで、アクティブスタイルは厳密に「/」のみに適用され、「/about」「/hoge」「/hoge/foo」などには適用されない。

`<router-link to="/" exact>Home</router-link>`

なお、完全一致した場合に適用されるスタイルクラスは、exact-active-class属性で指定できる(既定値はrouter-link-exact-active)。


##### replace属性

既定では、ルータによるページ遷移はブラウザ履歴にも記録される(つまり、[戻る]ボタンで前の状態に戻ることができる)。しかし、replace属性を付与した場合は、履歴は記録されず、[戻る]ボタンで前の状態に戻ることはできなくなる。$router.replaceメソッドに相当する属性。

`<router-link to="/about" replace>About</router-link>`

##### append属性

append属性を付与することで、to属性は現在のパスからの相対パスと見なされる。
たとえば、現在のパスが「～/about」の場合、以下のリンクは「～/about/hoge」に移動する(append属性がない場合は、「～/hoge」)。

`<router-link to="hoge" append>Hoge</router-link>`

##### tag属性

`<router-link>`要素は、既定でアンカータグを生成するが、時として、別のタグを割り当てたいこともある。その場合には、tag属性を利用することで、任意のタグをリンクにできる。たとえば以下は、リンクをボタン形式で生成する例。

`<router-link to="/about" tag="button">About</router-link>`

clickイベントの処理は、`<router-link>`要素が内部的に補う。ボタンに限らず、`<div>`、`<span>`、`<li>`など、任意のタグを割り当て可能。
さらに、以下のようにリンクを他の要素でラップすることも可能。この場合、リンク先は配下のアンカータグに反映される。

```
<router-link tag="div" to="/about">
    <a>About</a>
</router-link>
```

##### event属性

`<router-link>`要素は、既定でclickイベントを補足する。この挙動を変更するのがevent属性。たとえば以下は、mouseoverイベントで画面遷移を発生させる。

`<router-link to="/about" event="mouseover">About</router-link>`

### ルーティングにかかわるその他のテクニック

#### ルートパラメーター変化にかかわる注意点

Vue Routerでは、ルートパラメーターだけが異なるページ遷移では、**同一コンポーネントインスタンスを再利用する**点に注意する。これは同じインスタンスを破棄→再生成するよりも効率的だが、思わぬ落とし穴の原因にもなる。
具体的な例として、:aidパラメーター(記事コード)を受け取って、これをライフサイクルフック(created)でaidプロパティに反映させる例。

```Article.vue
<template>
    <span>記事コード: {{ aid }}</span>
</template>
<script>
export default {
    name: 'Article',
    data() {
        return {
            aid: 0
        }
    },
    created() {
        // 初期化時にルートパラメーターを取得
        this.aid = this.$route.params.aid
    }
}
</script>
```

このようなコンポーネントで、たとえば「/article/10」から「/article/108」にページ移動してみる。これはまさにルートパラメーターだけが変化するページ遷移だが、記事番号が変化しない。
インスタンスを再利用しているため、ライフサイクルフックが呼び出されない。これを回避するには、ウォッチャーを利用する。

```
export default {
    ...中略...
    watch: {
        '$route'(to, from) {
            this.aid = to.params.aid
        }
    }
}
```

$route(ルート情報)の変更時にaidを詰め直している。
同じページ移動で、今度は記事番号が正しく反映されるか確認する。

##### ルーティング時にアニメーションを適用する

`<router-view>`要素(表示領域)を`<transition>`要素でくくることで、ルーティング時にアニメーションを適用することも可能。

``` App.vue
<transition>
    <router-view>
</transition>
```

トランジションのためのスタイルシートが必要。
もしもページ(ルート)単位にアニメーションを変更したいならば、コンポーネントのルート要素を`<transition>`要素でくくっても構わない。
この場合は、コンポーネント単位にアニメーション定義を区別するために、name属性は必須。

```About.vue
<template>
    <transition name="about" appear>
        <div class="about">...</div>
    </transition>
</template>
```

##### ルーティング時のスクロールを制御する

Router(VueRouter)オブジェクトのscrollBehaviorオプションを利用することで、ルーティング時のスクロール状態を制御できる。

```router.js
export default new Router({
    ...中略...
    scrollBehavior(to, from, savedPosition) {
        // [戻る]ボタンでの移動は以前の位置を保持
        if (savedPosition) {
            return savedPosition
        } else {
            // ハッシュ(#～)がある場合は、指定の要素位置へ
            if (to.hash) {
                return { selector: to.hash }
            // さもなくば先頭位置に移動
            } else {
                return { x: 0, y: 0 }
            }
        }
    }
})
```

scrollBehaviorメソッドは、

* 引数として「遷移先のルート情報(to)」「遷移元のルート情報(from)」「スクロール情報(savedPosition)」を受け取り、
* 戻り値として、遷移後のスクロール位置を返す。

引数savedPositionは、ブラウザネイティブな[戻る]ボタンを利用したときにだけ有効な情報で、前回のスクロール位置を返す。
サンプルでもsavedPositionが存在する場合はその位置に移動し、そうでない場合にはハッシュ(#～)の有無によって、指定の要素か、先頭位置に移動する。
戻り値のスクロール位置(オブジェクト)は、以下のような形式で洗わす。

戻り値の形式 | 概要
--- | ---
savedPosition | 前回のスクロール位置
{ x: number, y: number } | 指定のX／Y座標
{ selector: string } | セレクター式が表す要素位置
{ selector: string, offset: { x: number, y: number }} | セレクター位置が表す要素からの相対位置
falsyな値 | スクロールしない

##### ルート単位の認証

ナビゲーションガードを利用することで、当k帝のページ(ルート)に認証を課すこともできる。認証すべきページには、以下のようなmeta - isRequestAuthオプション(trueで認証を要求)を宣言しておく。

```router.js
routes: [
    ...中略...
    // ログインページへのルート
    {
        path: '/signin',
        name: 'signin',
        component: Signin
    },
    // 認証を要求するルート
    {
        path: '/about',
        name: 'about',
        component: About,
        meta: {
            isRequestAuth: true
        }
    }
]
```

後は、グローバルガード(beforeEach)でisRequestAuthオプションの有無を判定し、値がtrueで、かつ、未認証である場合にログインページにリダイレクトするようにする。

```router.js
router.beforeEach((to, from, next) => {
    // 認証を要求しており、認証済みでない場合にログインページに移動
    if (to.matched.some(route => route.meta.isRequestAuth) && !isAuthed()) {
        next({ path: '/signin', query: { path: to.fullPath }})
    } else {
        // 認証済み、または認証を要求しないページはそのまま表示
        next()
    }
});
```

matchedプロパティはマッチしたすべてのルートを表す(入れ子になったルートでは、すべての親ルートを取得する)。ここでは、someメソッドでマッチしたルートを順に取り出し、いずれかのルートが認証を要求しているか(=meta.isRequestAuthプロパティがtrueであるか)を確認している。
認証を要求している場合にログインページ(/signin)に移動するのはnext関数の役割。その際、ログインページから本来要求されたページに移動できるよう、クエリ情報(query)として本来の移動先(to.fullPath)を渡しておく。


## Vuex

Vuexは、アプリで扱う状態(データ)を集中的に管理するためのライブラリ。状態管理ライブラリとも呼ばれる。

### Vuexとは

Vuexを導入することで、以下のようなメリットがある。

* アプリに散在するデータを一元的なストアで管理できる
* コンポーネント階層にかかわらずストアを直接参照できるので、出たの受け渡しコードが現象する
* ストア上のデータはリアクティブなので、コンポーネントとも自動で同期される
* データの更新フローが一貫するので、コードの見通しが改善する

状態管理ライブラリは、サーバーサイドでのデータベースと同じで、後から導入するとなると、データにかかわるコードに影響が及ぶ。


### Vuexの準備

Vue CLIを利用する場合、プロジェクト作成時に[Manually, select features](カスタムインストール)を選択してVuexを有効にするか、後から`vue add`コマンドでVuexを組み込む。
Vuexを有効にした場合、プロジェクト配下の`/src`フォルダには`store.js`というファイルが追加される。`store.js`は、ストア本体に加えて、ストア操作のためのメソッドを管理するためのファイル。

### Vuexの基本

#### Vuexを利用したカウンターアプリ

##### [1] ストアを準備する

データを格納するストアと、出し入れのためのメソッドを準備する。
Vue CLIを利用しているなら、`/src/store.js`にVuexストアのための骨組みが生成されている。

```store.js
// Vuexを有効化する
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// ストアを作成する
export default new Vuex.Store({
    // 厳密モードを有効にする
    // ステートをミューテーション以外で更新するのはVuexの思想に反している。
    // そこでミューテーション以外からのステート更新を監視し、反したコードを警告するのがこのモードの役割。オーバーヘッドが大きくなる。
    strict: true,
    // ストアにデータの初期値を定義する
    state: {
        count: 0
    },
    // ステート操作のためのメソッドを定義する
    // ステート操作のメソッドのことをミューテーションと呼ぶ
    mutations: {
        minus(state) {
            state.count--
        },
        plus(state) {
            state.count++
        }
    },
    actions: {
    }
})
```

##### [2] ストアをアプリに登録する

[1]で定義したストアをアプリに登録しているのは以下のコード。Vue CLIでVuexをインストールした場合には、このコードは自動で登録されている。

```main.js
import store from './store'
...中略...
new Vue({
    // Vueコンストラクタのstoreオプションとして引き渡す
    // これでApp配下のすべてのコンポーネントで、「this.$store.～」でVuexストアにアクセスできるようになる
    store,
    render: h => h(App)
}).$mount('#app')
```

##### [3] コンポーネントからストアを呼び出す

```App.vue
<template>
    <div>
        <input type="button" value="-" v-on:click="minus">
        {{ count }}
        <input type="button" value="*" v-on:click="plus">
    </div>
</template>

<script>
export default {
    name: 'app',
    computed: {
        // 現在のカウント値を取得
        count() {
            return this.$store.state.count
        }
    },
    methods: {
        // [-] ボタンでカウント値をデクリメント
        minus() {
            this.$store.commit('minus')
        },
        // [+] ボタンでカウント値をインクリメント
        plus() {
            this.$store.commit('plus')
        }
    }
}
</script>
```

ストア本体のプロパティにアクセスするならば、`this.$store.state.count`のように表す。
定義済みのミューテーションは、commitメソッド経由で呼び出す。引数はそれぞれミューテーションの型(名前)。

##### 補足: mapStateヘルパー

Vuexでは、ステートと算出プロパティとを紐付けるためのヘルパー関数としてmapStateを提供している。
mapStateヘルパーには、ステートのプロパティを文字列配列として渡すだけ。

```App.vue
import { mapState } from 'vuex'
...中略...
export default {
    ...中略...
    computed: mapState([ 'count' ]),
    ...中略...
}
```

mapStateヘルパーを利用することで、ストア上のプロパティを同名の算出プロパティに紐付けられる。複数のプロパティを列挙しても構わない。
別名を付与したい場合は、以下のように「別名: 元の名前, ...」のオブジェクト形式でマッピングを定義することもできる。以下であれば、counプロパティにcountNumber算出プロパティでアクセスできるようにする。

```
mapState({
    countNumber: 'count'
})
```

さらに、他の(ストアと関係ない)算出プロパティとまとめたい、配列／オブジェクト形式のmapStateを混在させたい、などのケースでは、スプレッド演算子(`...`)を利用する。

```
// ストア以外の算出プロパティとマージ
computed: {
    otherProp() {   /* 他の算出プロパティ */ },
    ...mapState([ 'count' ])
}

// 配列／オブジェクト形式のマッピングを統合
computed: {
    ...mapState([ 'count' ]),
    ...mapState({ countNumber: 'count' })
}
```

##### スプレッド演算子

配列／オブジェクトを個々の値に分解できる。個々の値とは、配列であればそのまま個々の要素、オブジェクトであれば「キー: 値」のペア。
ES2015で導入された構文で、複数の配列／オブジェクトをまとめるような用途で利用する。

```
let data1 = [ ...[1, 2], 3, 4];
console.log(data1);     // 結果: [ 1, 2, 3, 4 ]
let data2 = { ...{a: 1, b: 2 }, c: 3, d: 4 };
console.log(data2);     // 結果: { a: 1, b: 2, c: 3, d: 4 }
```

### Vuexストアを構成する要素

#### ステートの内容を加工＆取得する ～ ゲッター

コンポーネントでいうところの算出プロパティとメソッドの中間のような仕組み。
引数は渡せるが、セッターを設置することはできない。

```store.js
export default new Vuex.Store({
    state: {
        books: [
            {
                isbn: '9784-8222-5389-9',
                title: '作って楽しむプログラミング HTML5超入門',
                price: 2000
            },
           ...中略...
        ]
    },
    getters: {
        booksCount(state) {
            return state.books.length
        },
        getBooksByPrice(state) {
            return price => {
                return state.books.filter(book => book.price < price)
            }
        }
    },
    ...中略...
})
```

ゲッターは、gettersオプションで定義する。
state/mutationsと並列の関係になるように追記する。
引数を受け取らないゲッターは、引数として受け取ったステート(state)を介して、`state.books`のように配下のプロパティにアクセスできる(ミューテーションと同じ)。
引数を受け取るゲッター関数は、ゲッターによる取得値ではなく「取得値を返すための関数」を返さなければならない。
例では、配下のアロー関数では本来の引数(price)を受け取り、その値をもとに書籍情報(store.books)の内容を絞り込んでいる。filterメソッドは、JavaScript標準のメソッドで、条件式(ここでは「book.price < price」)を満たす要素だけ取得する。ステート(state)には、ゲッター本体が引数として受け取っているため、配下のアロー関数でもアクセスできる。

##### 他のゲッターを参照する

ゲッターは、第2引数としてゲッター群を受け取ることで、他のゲッターを参照することも可能。たとえば以下は、getBooksByPriceゲッターを経由して3000円未満の書籍数を取得する。

```
BooksCount3000(state, getters) {
    return getters.getBooksByPrice(3000).length
}
```
#### コンポーネントからゲッターを参照する

ゲッターを参照するAppコンポーネントの例。

```
<template>
    <div>
        <p>書籍は全部で{{ booksCount }}冊あります。
        <ul v-for="b of getBooksByPrice(2500)" v-bind:key="b.isbn">
            <li>{{ b.title }} ({{ b.price}}円) <br>ISBN: {{ b.isbn }}</li>
        </ul>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
    name: 'app',
    computed: mapGetters([ 'booksCount' , 'getBooksByPrice' ])
}
</script>
```

ゲッターは、算出プロパティに登録しておく。無条件に同名の算出プロパティに紐付けるならば、mapGetters関数を利用するだけ。mapGetter関数の用法はmapState関数と同じ。
`computed`は以下のように表しても同じ。

```
computed: {
    booksCount() {
        return this.$store.getters.booksCount
    }
},
methods: {
    getBooksByPrice(price) {
        return this.$store.getters.getBooksByPrice(price)
    }
}
```

ゲッターには`this.$store.getters.～`でアクセスできる。引数なしのゲッターであればプロパティ(変数)形式で表し、引数ありのゲッターであればメソッド形式で表す。

##### 補足: ゲッターのキャッシュルール

ゲッターでは、引数を受け取るかどうかによって、キャッシュの挙動が変化する。
**引数を受け取らないゲッターはキャッシュされるが、引数を受け取るゲッターはキャッシュの対象外**になる。
よって、引数を受け取るゲッターは、極力、算出プロパティを介してキャッシュするのが望ましい。

```
computed: {
    ...中略...
    getBooksByPrice() {
        return this.$store.getters.getBooksByPrice(this.price)
    }
}
```

mapGetters関数による登録では、理屈上はメソッド(methods)になる。キャッシュ対象にはならない。

### ストアの状態を操作する ～ ミューテーション

#### 呼び出し時に引数を渡す

普通のメソッドと同じく、ミューテーションも引数を持つことが可能。この引数のことを**ペイロード**と呼ぶ。

```store.js
export default new Vuex.Store({
    ...中略...
    mutations: {
        addBook(state, payload) {
            state.books.push(payload.book)
        }
    },
    ...中略...
})
```

引数payloadがペイロード。複数の情報を渡せるように、ペイロードは「名前: 値, ...」のオブジェクト形式で表すのが基本。
このようなミューテーションを呼び出しているのが以下の例。

```
<form v-on:submit.prevent="onclick">
    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" v-model="isbn"><br>
    <label for="title">書名:</label>
    <input type="text" id="title" v-model="title"><br>
    <label for="price">価格:</label>
    <input type="number" id="price" v-model="price"><br>
    <input type="submit" value="登録">
</form>
<hr>
...中略...
// フォーム内で扱う情報を準備
data() {
    return {
        isbn: '',
        title: '',
        price: 0
    }
},
methods: {
    // [登録] ボタンクリックでストアに反映
    onclick() {
        this.$store.commit('addBook', {
            book: {
                isbn: this.isbn, title: this.title, price: this.price
            }
        })
    }
}
```

ペイロードは、commitメソッドの第2引数として渡す。第1引数がミューテーションのタイプ(型)を表すのに対して、ペイロード(荷物=データ本体)。

#### オブジェクト形式でのcommitメソッド呼び出し

別解として、commitメソッドでは、ミューテーション型とペイロードとを、ひとつのオブジェクトにまとめて渡すこともできる。

```
this.$store.commit({
    type: 'addBook'',
    book: {
        isbn: this.isbn, title: this.title, price: this.price
    }
})
```

この場合、ミューテーションの型は、typeプロパティとして渡す。

#### Vuexストアでの双方向バインディング

Vuexストアに対して双方向バインディングを実施する場合、そのままステートをv-modelに渡すことはできない。

```App.vue
<form>
    <label for="name">氏名:</label>
    <input id="name" type="text" v-model="$store.state.name">
</form>
```

```store.js
export default new Vuex.Store({
    strict: true,
    state: {
        name: ''
    },
    ...中略...
}
```

厳密モードにおいて、ミューテーション以外での値の更新は「do not mutate vuex store state outside mutation handlers.」のようなエラーとなる。
このような状況では、ステートを取得／更新するための算出プロパティを準備する。

```App.vue
<input id="name" type="text" v-model="name">
...中略...
computed: {
    name: {
        get() {
            return this.$store.state.name
        },
        set (value) {
            this.$store.commit('updateName', value)
        }
    }
}
```

```store.js
mutations: {
    updateName(state, name) {
        state.name = name
    }
},
```

これでステート(name)への値の出し入れをv-model経由で行えるようになる。

#### ミューテーション型を定数化する

定数化することで、以下のようなメリットがある。

* 定数を1カ所にまとめることで、アプリで利用できる操作が一望できる
* エディターのコード補完機能を利用すれば、入力が容易になる
* 同じく、型のタイプミスも減る

型は、定数専用の別ファイルを用意して、列挙しておく(store.jsと同じく、/srcフォルダの直下に配置する)。

```mutation-types.js
export const ADD_BOOK = 'addBook';
```

あとは、store.jsを定数対応に書き換える。

```store.js
import { ADD_BOOK } from './mutation-types'
...中略...
export default new Vuex.Store({
    ...中略...
    export default new Vuex.Store({
        ...中略...
        mutations: {
            [ADD_BOOK] (state, payload) { ... }
        }
    },
    ...中略...
)
```

[ADD_BOOK]の記述は、ES2015のcomputed property nameという昨日。ブラケットで囲まれた式の値を解釈して、メソッド名とする。

#### ミューテーションの呼び出しを簡単化する

mapState、mapGettersと同じく、ミューテーションにも、コンポーネントのメソッドとの紐付けを簡単化するために、mapMutations関数が用意されている。

```App.vue
import {mapMutations } from 'vuex'
...中略...
methods: mapMutations([ 'plus', 'minus' ]),
```

### 非同期処理を実装する ～ アクション

ミューテーションには非同期処理を含んではいけない。
非同期処理と状態(ステート)の更新とが絡み合うことで、状態の追跡が難しくなるため。  
そこで、ミューテーションは常に同期処理として表し、非同期処理はアクションとして切り出す。非同期処理(アクション)で得た結果で、関連するミューテーションを呼び出す(=コミットする)ことで、状態(値)を意図した順序で更新できる。
値の変化も追跡しやすくなる。


ミューテーションをボタンクリックから5秒後に(=非同期に)実行してみる。

```store.js
actions: {
    addAsync(context, payload) {
        // 5000ミリ秒後にミューテーション(ADD_BOOK)をコミット
        setTimeout(function () {
            context.commit(ADD_BOOK, payload)
        }, 5000)
    }
}
```

アクションでは、引数としてコンテキストオブジェクト(context)を受け取る。コンテキストオブジェクトは、Vuexストアのインスタンスによく似たオブジェクトで、ストアは以下の主な要素にアクセスするために、以下のようなメンバーを提供している。

メンバー | 概要
--- | ---
commit | ミューテーションをコミット
dispatch | アクションをディスパッチ
getters | ゲッターを取得
rootGetters | ルートのゲッターを取得
state | ステートを取得
rootState | ルートステートを取得


次の例では、setTimeoutメソッドの中でcommitメソッドを呼び出して、ミューテーションをコミットしているが、同じようにステート、ゲッターにアクセスすることも可能。
アクションの第2引数(ここではpayload)では、ミューテーションと同じく、任意の引数を受け取れる。

##### ES2015の分割代入

ES2015の分割代入を利用すれば、少しだけアクション内のコードを簡単化できる。

```
addAsync({ commit }, payload) {
    setTimeout(function () {
        commit(ADD_BOOK, payload)
    }, 5000)
}
```

`{ commit }`が分割代入。渡されたオブジェクト(コンテキスト)からプロパティ(ここではcommit)を取り出して、同名の変数に再割り当てする。これで、アクション内では(context.commitではなく)単なるcommitと書けるようになる。

#### コンポーネントからアクションを呼び出す

準備したaddAsyncアクションを、コンポーネントから呼び出してみる。

```App.vue
export default {
    ...中略...
    methods: {
        onclick() {
            ...中略...
            this.$store.dispatch('addAsync', {
                book: {
                    isbn: this.isbn, title: this.title, price: this.price
                }
            })
        }
    }
}
```

アクションを呼び出すことをディスパッチすると言い、dispatchメソッドを利用する。
dispatchメソッドの用法は、commitメソッドにも似ており、

* アクションの型
* ペイロード(追加の引数)

の順で指定するだけ。すべての引数をオブジェクトリテラルにまとめて、以下のように表してもよい。

```
this.$store.dispatch({
    type: 'addAsync',
    book: {
        isbn: this.isbn, title: this.title, price: this.price
    }
})
```

#### アクションを紐付けるmapAction関数

アクションをコンポーネントに紐付けるためのmapActions関数がある。addAsyncアクションを同名のaddAsyncメソッドに、同じくaddAsyncアクションをaddメソッドに、それぞれ紐付けるならば、以下のように表せる。

```
import { mapActions } from 'vuex'
...中略...
methods: {
    // this.$store.dispatch('addAsync', ...)をthis.addAsync(...)に紐付け
    ...mapActions([ 'addAsync ']),
    // this.$store.dispatch('addAsync', ...)をthis.add(...)に紐付け
    ...mapActions({ add: 'addAsync' })
}
```

上のように紐付けられたコードは、以下のように呼び出せる。

```
this.addAsync({
    book: { isbn: this.isbn, title: this.title, price: this.price }
})
```

## 巨大なストアを分割管理する ～ モジュール

### モジュールの定義

```main-store.js
export default {
    state: {
        // 現在の時刻で初期化
        updated: (new Date()).toTimeString(),
    },
    mutations: {
        // updatedを現在時刻で更新
        setUpdated(state) {
            state.updated = (new Date()).toTimeString()
        }
    },
    getters: {
        // updatedを取得
        localUpdated(state) {
            return state.updated
        }
    }
}
```

```sub-store.js
export default {
    state: {
        // 現在の時刻
        updated: (new Date()).toLocaleTimeString(),
    },
    mutations: {
        // updatedを現在時刻で更新
        setUpdated(state) {
            state.updated = (new Date()).toLocaleTimeString()
        }
    }
}
```

```store.js
import MainModule from './main-store'
import SubModule from './sub-store'
...中略...
// 複数のモジュールを束ねたルートモジュール
export default new Vuex.Store({
    modules: {
        main: MainModule,
        sub: SubModule
    }
})
```

モジュール化されたストアは、それぞれ「オプション名: 値, ...」形式のオブジェクトとして定義する。
オブジェクトの内容は、これまでVuex.Storeコンストラクタで指定していたものと同じ。
準備したモジュールは、最終的にVuex.Storeコンストラクタのmodulesオプションに登録することで、Vuexストアに統合される。
ここでは、MainModule、SubModuleモジュールを、それぞれmain、subという名前で登録しているが、同名で登録するならば、以下のように表してもよい。

```
modules: {
    MainModule,
    SubModule
}
```

これでルートストアの配下に、main、subモジュールストアが配置されたことになる。

### モジュールへのアクセス

```App.vue
<template>
    <div id="app">
    メイン: {{ mainUpdated }}<br>
    サブ: {{ subUpdated }}<br>
    <input type="button" value="更新" v-on:click="setUpdated">
    </div>
</template>

<script>
export default {
    name: 'app',
    computed: {
        // mainモジュールの時刻を取得
        mainUpdated() {
            return this.$store.state.main.updated
        },
        // subモジュールの時刻を取得
        subUpdated() {
            return this.$store.state.sub.updated
        }
    },
    methods: {
        // main／subモジュールの時刻(updated)を更新
        setUpdated() {
            this.$store.commit('setUpdated79)
        }
    }
}
</script>
```

モジュール内のステートには、「$store.state.モジュール名.ステート名」でアクセスできる。
一方、ゲッターやミューテーション、アクションは、既定ではグローバルな名前空間に登録される。つまり、呼び出しに際しても、非モジュールなストアと同じ構文でアクセスできる。
このため、モジュール間で同名のミューテーションやアクションが存在する場合には、合致するものすべてが呼び出される。

### 名前空間を分離する

Vuexでは、名前空間(ネームスペース)を明確に分離することができる。
これには、個々のモジュールでnamespacedオプションをtrueに設定する。

```
export default {
    namespaced: true,
    ...中略...
}
```

名前空間を分離した場合、ミューテーションなどへのアクセスは「名前空間/型名」の形式で表す。

```App.vue
methods: {
    setUpdated() {
        this.$store.commit('main/setUpdated')
        this.$store.commit('sub/setUpdated')
    }
}
```

モジュールをネストしている場合には、スラッシュを連ねて、「store.commit('main/child/setUpdated')」のようにも表せる。

### 名前空間付きモジュールから他のモジュールへアクセスする

モジュールに名前空間を付けた場合にも、配管ゲッター、アクションなどの記述は変化しない。
たとえば、以下はupdatedプロパティ(ステート)を取得するlocalUpdatedゲッターの例。

```main-store.js
getters: {
    localUpdated(state) {
        return state.updated
    }
}
```

ゲッター関数が受け取る引数`state`は、厳密には、現在のモジュールは以下のステート(ローカルステート)を表すから。もしもルートモジュールのステートやゲッターにアクセスしたい場合には、以下のように第3引数(rootState)、第4引数(rootGetters)を利用する。
以下は、ルートモジュールからhogeプロパティを取得する例。

```
getters: {
    hoge(state, getters, rootState, rootGetters) {
        return rootState.hoge
    }
}
```

同じくアクションであれば、コンテキストオブジェクトがrootState.rootGettersプロパティを提供している。同じく、これらを介してルートモジュールにアクセスできる。
ただし、ルートモジュールのアクションやミューテーションにアクセスするには、rootCommit、rootDispatchなどのメソッドがあるわけではないため注意が必要。代わりにcommit、dispatchメソッドの第3引数に対して、`{ root: true }`オプションを追加する。これで(ローカルのアクション、ミューテーションではなく)ルートモジュールのアクション、ミューテーションをディスパッチ、コミットする。

```
actions: {
    hogeAction(context) {
        // ルートモジュールのhogeミューテーションをコミット
        context.commit('hoge', null, { root: true })
    }
}
```

第2引数にはペイロード(=ミューテーションで利用する実データ)を渡す。rootオプションを利用する場合には、第2引数も省略できないため、ペイロードがなくとも仮にnullを渡しておく。

#### mapXxxxx関数によるストアのマッピング

名前空間付きモジュールを呼び出す場合、mapXxxxx関数の記法も変化する。

```App.vue
computed: mapState({
    updated: state => state.main.updated
}),
methods: {
    ...中略...
    ...mapMutations([ 'main/setUpdated', 'sub/setUpdated' ])
}
```

ただし、この場合、ミューテーションの呼び出しは`this['main/setUpdated']()`のようになり、見た目にもあまり美しくない。明示的に、

```
...mapMutations({
    setUpdated: 'main/setUpdated',
    ...中略...
})
```

としても構わないが、紐付けるべき要素が増えてくれば冗長になる。そのような場合には、mapXxxxx関数の第1引数にモジュール名を宣言するのがシンプル。

```
...mapMutations('main', [ 'setUpdated', ... ]),
```

この場合、呼び出し側も`this.setUpdated()`となる。さらに第1引数でのモジュール指定すら略記したいならば、createNamespacedHelpers関数で名前空間対応のmapXxxxx関数を作成しても構わない。

```
import { createNamespacedHelpers } from 'vuex'
// mainモジュール対応のmapState/mapMutationsを準備
const { mapState, mapMutations } = createNamespacedHelpers('main')
...中略...
// main/setUpdatedに紐付け
methods: {
    ...中略...
    ...mapMutations([ 'setUpdated', .. ]),
}
```

コンポーネントの中で複数のmapXxxxx関数を呼び出している場合には、この方法がより便利。


## テスト

Vue CLIでも以下のようなテストをサポートしている。

テストの種類 | 概要
--- | ---
単体テスト | ユニットテストとも言う。コンポーネント、JavaScriptオブジェクト(メソッド)など要素単体の動作をテスト
E2E(End to End)テスト | シナリオテスト、インテグレーションテストとも言う。複数のコンポーネントにまたがって、エンドユーザーの実際の操作に沿った挙動の正否をテスト

### 単体テスト

**単体テスト(ユニットテスト)**とは、アプリを構成する個々の要素が、それ単体として正しく動作するかどうかを確認するためのテスト。

#### 単体テストの準備

Vue CLIを利用している場合、プロジェクト作成時に`[Manually select features](カスタムインストール)`を選択することで、単体テストのためのライブラリや設定を組み込むことが可能。
カスタムインストールの途中で、まず`Unit Testing`を有効にする。すると、以下のように組み込むべき単体ライブラリを訊かれる。
ここではJestを選択する。

Jest(https://jestjs.io/ja/)は、Facebook社が開発を進めているテスティングフレームワーク。初期設定などの手間をかけずに、即座にテストを書き始められる。
Vue.jsでは、Vueコンポーネントをテストするためのvue-test-utilsと、このJestを組み合わせてテストするのが一般的。
Jestを有効にした場合、Vue CLI1プロジェクトには、以下のようなフォルダー／ファイルが追加される。

```
root(プロジェクトルート)
 └─ tests
      ├─ unit
      │   ├─ .eslintrc.js       ESLintの設定ファイル
      │   └─ example.spec.js    既定で用意されたテストコード
      └─ jest.config.js         Jestの設定ファイル
```

jest.config.jsから設定を加えることも可能。詳細は本家サイトから「Configuring Jest」(https://jestjs.io/docs/ja/configuration)を参照。


#### テストスクリプトの基本

##### [1] テストコードを準備する

テストコードは、/tests/unitフォルダ配下にintro.spec.jsのような名前で保存する。「intro」の部分は、一般的には、テスト対象のファイル名とするのが見た目にもわかりやすい。

```intro.spec.js
describe('Jestの基本', () => {
    beforeEach(() => {
        console.log(new Date().toLocaleString())
    })

    it('はじめてのテスト', () => {
        expect(1 + 1).toBe(2)
    })
})
```

Jestによるテストコードでは、まず全体をdescribeメソッドで囲む。

```
describe(name, specs)

name: テストスイートの名前
specs: テストケース(群)
```

テストスイートとは、関連するテストを束ねる入れ物のようなもの。具体的なテスト(=テストケース)は、引数specs(関数オブジェクト)の配下で宣言する。
beforeEachメソッドは、個々のテストケースが実行される前に呼び出されるべき初期化処理を表す。今回の例では、現在時刻を表示しているだけ。一般的には、テストで利用するリソース(たとえばテスト対象のオブジェクト)を準備するのに利用する。初期化すべきものがない場合には、省略しても構わない。終了処理には同じようにafterEachメソッドを利用する。

```
it(name, test)

name: テストケースの名前
test: テストの内容
```

ここでは「はじめてのテスト」という名前で、テストケースをひとつだけ定義している。もちろん、必要に応じて、複数のテストを列記しても構わない。その場合、itメソッドも複数記述する。
引数testの中では、以下の構文でコードの結果を検査していく。

```
expect(resultValue).matcher(expectValue)

resultValue: テスト対象のコード(式)
matcher: 検証メソッド
expectValue: 期待する値
```

この例では「1 + 1」の結果が2に等しい(toBe)ことを確認している。実際のテストでは、「1 + 1」の部分がテスト対象コードの呼び出しになる。
toBeはMatcherとも呼ばれ、expectメソッドで示された結果値(resultValue)が期待したものであるかを確認するためのメソッド。Jestでは、標準で以下の表のようなMatcherを用意している。

分類 | Matcher | 概要
--- | --- | ---
一般 | toBe(value) | 値がvalueと等しいか
一般 | toEqual(value) | 値がvalueと等しいか(配列、オブジェクト配下の要素も再帰的に判定)
真偽 | toBeNull() | 値がnullであるか
真偽 | toBeUndefined() | 値がundefinedであるか
真偽 | toBeDefined() | 値がなんらかの値を持つか(=undefinedでないか)
真偽 | toBeTruthy() | 値がtrueと評価できるか
真偽 | toBeFalsy() | 値がfalseと評価できるか
数値 | toBeCloseTo(value, digits) | 値がvalueと等しいか(小数点以下digits桁までを比較)
数値 | toBeGreaterThan(value) | 値がvalueよりも大きいか
数値 | toBeGreaterThanOrEqual(value) | 値がvalue以上か
数値 | toBeLessThan(value) | 値がvalue未満か
数値 | toBeLessThanOrEqual(value) | 値がvalue以下か
文字列 | toMatch(reg) | 値が正規表現regにマッチするか
配列 | toContain(value) | 値に候補地valueが含まれるか
例外 | toThrow([err]) | 指定されたコードが例外を発生するか(引数errは例外オブジェクト、文字列、正規表現のいずれか。文字列／正規表現はエラーメッセージにマッチするか)

否定を表現するならば、notメソッドを利用する。

`expect(1 + 1).not.toBe(2)`

##### [2] テストを準備する

準備したテストコードを実行するには、プロジェクトルートで`npx vue-cli-service test:unit`コマンドを実行する。以下では引数としてintro.spec.jsを指定しているため、intro.spec.jsだけを実行するが、引数なしですべてのテストをまとめて実行することもできる。

```
> npx vue-cli-service test:unit intro.spec.js
```

テストスイートやテストケースともにひとつのうちひとつが成功した(=1 passed, 1 total)ことを確認する。
あえてテストが失敗するように、以下のように修正して試す。

`expect(1 + 1).toBe(15)`

テストを再実行した結果、15を期待しているのに、受け取った結果は2となることが通知される。

#### コンポーネントのテスト

Vueアプリを構成する要素(コンポーネント)をテストする方法を学ぶ。以下は、Vue CLI標準で用意されたHelloWorldコンポーネントをテストするためのexample.spec.js。Jest組み込み時に、既定で用意されたサンプルテスト。

```example.spec.js
import { shallowMount } from '@vue/test-utils'
import HelloWorld from '@/components/HellowWorld.vue'

describe('HelloWorld.vue', () => {
    it('renders props.msg when passed', () => {
        const msg = 'new message'
        const wrapper = shallowMount(HelloWorld, {
            propsData: { msg }
        })
        expect(wrapper.text()).toMatch(msg)
    })
})
```

コンポーネントのテストには、まず、vue-test-utilsモジュール(配下のshallowMountメソッド)と、テスト対象のコンポーネント(ここではHelloWorld.vue)をインポートしておく。
コンポーネントを描画(マウント)するのは、shallowMountメソッドの役割。

```
shallowMount(comp, opts)

comp: マウントすべきコンポーネント
opts: コンポーネントに流すオプション
```

オプション | 概要
--- | ---
context | コンテキスト情報(関数型コンポーネントのみ)
slots | スロット情報(「名前: コンテンツ, ...」形式)
scopedSlots | スコープ付きスロット情報
stubs | スタブ
mocks | 追加のインスタンスプロパティ(「名前: 値, ...」形式)
localVue | createLocalVueで作成されたVueのローカルコピー
attrs | コンポーネントの属性($attrs)情報
propsData | コンポーネントのプロパティ(props)情報
parentComponent | 親として利用するコンポーネント
sync | コンポーネントを同期的に描画するか(既定はtrue)

例では、HelloWorldコンポーネントを「msg="new message"」属性を指定してマウントしなさい、という意味になる。
shallowMountメソッドの戻り値は、名前のとおり、Vueコンポーネントのラッパー(Wrapper)で、コンポーネントを取得／テストするための種々のメソッドを提供する。
以下は、その主なメンバー。

分類 | メンバー | 概要
基本 | vm | Vueインスタンス(データオブジェクトなどへのアクセスに利用)
基本 | element | ルート要素
基本 | attributes() | 要素の属性情報を取得
基本 | classes() | 要素のclass名を取得(配列)
基本 | emitted() | カスタムイベントの情報を取得(「イベント名: [値, ...], ...」形式)
基本 | html() | DOMノードをHTML文字列で取得
基本 | name() | コンポーネント名、またはタグ名を取得
基本 | props() | propsオブジェクトを取得
基本 | text() | テキストを取得
検索 | find(selector) | 指定されたセレクターで配下の要素を取得(単一)
検索 | findAll(selector) | 指定されたセレクターで配下の要素を取得(複数)
判定 | contains(selector) | 指定されたセレクターに合致する要素を含んでいるか
判定 | exists() | 中身が空でないか
判定 | is(selector) | セレクターと一致しているか
判定 | isEmpty() | 子ノードを含んでいないか
判定 | isVisible() | 表示状態にあるか
判定 | isVueInstance() | Vueインスタンスか
設定 | setChecked() | チェックボックス、ラジオボタンをチェック状態に
設定 | setData(data) | データオブジェクトを設定
設定 | setMethods(methods) | メソッドを設定、更新
設定 | setProps(props) | プロパティを設定、更新
設定 | setValue(value) | テキスト、選択要素の値を設定、更新
その他 | trigger(event [, opts]) | イベントを発生(引数optsはイベント情報)
その他 | destroy() | インスタンスを破棄

例であれば、textメソッドで配下のテキストを取得し、そこにmsg(new message)が含まれているかを判定している。
より限定的に、配下のコンポーネントから`<h1>`要素を取り出し、そのテキストがmsgに等しいかを確認することもできる。以下のようにfindメソッドを利用する。

`expect(wrapper.find('h1').text()).toMatch(msg)`

findメソッドには任意のセレクター式を指定できる。コンポーネントの特定の要素を確認したい場合に、よく用いる。
コンポーネントのテストでは、まず、

* コンポーネントをマウント
* 値を取り出し
* その値を検証

という流れが基本。

##### setPropsメソッド

コンポーネントのプロパティ(属性)は、マウント時にpropsDataオプションで設定するばかりではない。sePropsメソッドで、属性値を変更し、結果の変化を確認することも可能。
例に以下のようなコードを追加する。setPropsメソッドには、propsDataオプションと同じく、「プロパティ名: 値, ...」形式のオブジェクトを引き渡す。

```example.spec.js
describe('HelloWorld.vue', () => {
    it('renders props.msg when passed', () => {
        ...中略...
        const new_msg = 'こんにちは、Vue!!'
        wrapper.setProps({msg: new_msg })
        expect(wrapper.find('h1').text()).toBe(new_msg)
    })
})
```

#### shallowMountメソッドとmountメソッド
vue-test-utilsモジュールは、コンポーネントをマウントするためにshallowMountとmountの、2種類のメソッドを提供している。具体的な例を示すために、標準で用意されているAppコンポーネントをshallowMount、mountメソッドそれぞれでアクセスし、コンソールに出力してみる。

```mount.spec.js
import { shallowMount, mount } from '@vue/test-utils'
import App from '@/App.vue'

describe('Mountの基本', () => {
    it('shallowMount vs mount', () => {
        let shallow = shallowMount(App)
        let deep = mount(App)
        // それぞれのマウント結果を確認
        console.log(shallow.html())
        console.log(deep.html())
    })
})
```

`> npx vue-cli-service test:unit mount.spec.js`

shallowMount、mountメソッドの結果は、子コンポーネントの描画で現れる。
mountメソッドの挙動は直。子コンポーネントもそのまま解釈し、その結果を描画する。
shallowMountメソッドは、子コンポーネントが`<helloworld-stub>`で置き換わって、そのまま描画される。スタブ(stub)とは、テストのための「ダミーのオブジェクト」という意味。
親コンポーネントをテストするうえで、子コンポーネントの解釈は必ずしも必要とは限らない。むしろ、子コンポーネントが他のサービスに依存しているなどの理由で、

* テストが無用に複雑になる
* 結果、思わぬエラーの原因となる(その対処にテストコードがさらに複雑化する)
* テストの処理時間が長くなる

など、種々のデメリットが想定される。
子コンポーネントとの連携に着目したいのでなければ、子コンポーネントはスタブ化し、親コンポーネントだけを描画するのがスマート。

##### 独自のスタブで置き換える

shallowMountメソッドは、子コンポーネントを既定で`<helloworld-stub>`のようなスタブで置き換える(既定のスタブは、そこにあるだけでなにもしない)。
しかし、テストのためにスタブそのものを自分で用意しても構わない。たとえば、HelloWorld.vueのスタブとして、以下のような.vueファイルを用意してみる。

```HelloStub.vue
<template>
    <div class="hello">
        <h1>{{ msg }}</h1>
    </div>
</template>

<script>
export default {
    name: 'hello-stud',
    props: {
        msg: String
    }
}
</script>

<style scoped>
h3 {
    margin: 40px 0 0
}
</style>
```

スタブとは言っても、オリジナルの.vueファイルを簡単化しただけで、特筆すべき点はない。一般的にも、コード部分を取り払って(または簡単化して)、簡単な出力を生成することになる。
このようなスタブを組み込むのは、shallowMountメソッドのstubsオプションの役割。

```mount.spec.js
import { shallowMount, mount } from '@vue/test-utils'
import HelloStub from './HelloStub.vue'
import App from '@/App.vue'

describe('Mountの基本', () => {
    ...中略...
    it('Custom Stub', () => {
        le shallow = shallowMount(App, {
            stubs: {
                'HelloWorld': HelloStub
            }
        })
        // コンポーネントの処理結果を出力
        console.log(shallow.html())
    })
})
```

stubsオプションには「コンポーネント名: スタブ, ...」形式のハッシュとして、スタブを指定する。これまでと同じく、既定のスタブを割り当てるだけであれば、

`'HelloWorld': true`

とするだけ。
テストを実行してみると、HelloStubの結果が、本来のHelloWorldコンポーネントの代わりに反映されていることが見て取れる。

#### 算出プロパティのテスト

算出プロパティをテストする際にも、マウントして、要素を取得、結果判定という流れは同じ。ただし、算出プロパティの値を確認するだけであれば、算出プロパティを直接実行し、結果を確認することもできる。
以下は、email属性で与えられたメールアドレスからローカル部分を取得し、すべて小文字で表示するMyComputeコンポーネントの例。

```MyCompute.vue
<template>
    <div id="email">{ localEmail }}</div>
</template>
<script>
export default {
    // 文字列型のemail属性
    props: {
        email: String
    },
    // メールアドレスの「@」以前を取得
    computed: {
        localEmail: function() {
            return this.email.split('@')[0].toLowerCase()
        }
    }
}
</script>
```

このlocalEmail算出プロパティをテストするためのコードが以下。

```compute.spec.js
import MyCompute from '@/components/MyCompute.vue'
...中略...
it('Computed Test', () => {
    const that = { email: 'HOGE@example.com' }
    expect(MyCompute.computed.localEmail.call(that)).toBe('hoge')
})
```

ポイントは`MyCompute.computed.localEmail.call(that)`。算出プロパティには「コンポーネント名.computed.プロパティ名」でアクセスできる。そのcallメソッドを呼び出すということは、変数thatがthisになるようにlocalEmailメソッドを呼び出すという意味。that(this)には、props/dataオプションに渡すべき内容を列挙しておく。
これでlocalEmailプロパティの結果を得られる。後は、Matcherで結果を判定するだけ。

#### イベントを伴うテスト

vue-test-utilsモジュールでは、ユーザー操作(イベント)を伴うテストも可能。
メールアドレスを登録すると、登録完了メッセージが表示される例。

```MyEvent.vue
<template>
    <div id="event">
        <form v-on:submit.prevent="onsubmit">
            <label>メールアドレス:
            <input id="email" v-model="email"></label>
            <input type="submit" value="登録">
        </form>
        <div id="result">{{ result }}</div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            email: '',      // メールアドレス
            result: ''      // 結果メッセージ
        }
    },

    methods: {
        // サブミット時にメッセージを生成
        onsubmit() {
            this.result = '登録完了: ' + this.email
        }
    }
}
</script>
```

このイベントハンドラーをテストするためのコード。

```event.spec.js
import MyEvent from '@/components/MyEvent.vue'
...中略...
it('Event Test', () => {
    const email = 'hoge@example.com'
    const wrapper = shallowMount(MyEvent)

    // テキストボックスへの入力＆サブミット
    wrapper.find('#email").setValue(email)
    wrapper.find("form").trigger('submit.prevent')

    // 結果の確認
    expect(wrapper.find('#result').text()).toContain('登録完了: ' + email)
})
```

findメソッドでテキストボックス、フォームを取得し操作する。
値を設定するのがsetValue、イベントを発生させるのがtriggerメソッドの役割。
triggerメソッドの引数には「submit.prevent」のような修飾子も含んだ形式で、イベント名を指定できる。

#### カスタムイベントを伴うテスト

親から子方向への情報の伝播を表すPropsに対して、子から親方向の伝播を担うのが$emit(カスタムイベント)だった。vue-test-utilsモジュール(Wrapperオブジェクト)では、これらカスタムイベントの情報を監視し、その発生回数、授受されたデータの内容などをテストすることもできる。
以下は、ボタンをクリックすると、カスタムイベントupdateが発生するようなコンポーネントの例。

```MyEmit.vue
<template>
    <div id="emit">
        <input type="button" value="送信" v-on:click="onupdate">
    </div>
</template>

<script>
export default {
    methods: {
        // ボタンクリック時にカスタムイベントを生成
        onupdate() {
            this.$emit('update')
            this.$emit('update', { name: 'Vue.js', version: '2.6.10' })
        }
    }
}
</script>
```

このようなコンポーネントで、ボタンクリック時に意図したイベントが発生しているかどうかを判定するのは、以下のテストコード。

```emit.spec.js
import MyEmit from '@/components/MyEmit.vue'
...中略...
it('$emit Test', () => {
    const wrapper = shallowMount(MyEmit)
    // ボタンをクリック
    wrapper.find('input').trigger('click')
    // カスタムイベントを取得
    const emit = wrapper.emitted()
    console.log(emit)       // 結果:{ update: [ [], [ [Object] ] ] }

    // updateイベントが発生しているか
    expect(emit.update).toBeTruthy()
    // updateイベントが何回発生したか
    expect(emit.update.length).toBe(2)
    // 2回目のupdateイベントのデータを確認
    expect(emnit.update[1][0].version).toBe('2.6.10')
})
```

ボタンクリックをシミュレートするのはtriggerメソッド。このタイミングで、my-emitコンポーネントのonupdateメソッドが呼び出され、カスタムイベントの情報がWrapperオブジェクトに格納される。カスタムイベント情報を取得するのは、emittedメソッドの役割。
イベント情報が取得できたら、後はこれまでと同じく、その内容を検証していく。
emittedメソッドの戻り値は「イベント名: 送信された値, ...」。「送信された値」は配列形式で、ひとつの要素がひとつのイベントで送信された値を表し、さらに、個々の要素が「引数, ...」の配列となっている点に注目する。

### E2Eテスト
**E2E (End to End)**テストは、複数のコンポーネントにまたがって、エンドユーザーの実際の操作をシミュレートするような用途で利用する。
ユニットテストで個々のコンポーネントの動作を確認した後、アプリをより本番環境に近い環境(クライアントサイドからサーバーサイドまで通して(End to End))で、最終的な動作を確認する。
**インテグレーションテスト**、**シナリオテスト**とも呼ばれ、リリース前の最終段階のテスト。

#### E2Eテストの準備

Vue CLIを利用している場合、プロジェクト作成時に`[Manually select features](カスタムインストール)`を選択することで、E2Eテストのためのライブラリ、設定を組み込むことが可能。
カスタムインストールの途中で、まず「E2E Testing」を有効にする。
すると後で組み込むべきE2Eライブラリを訊かれる。`Nightwatch`を選択する。

Nightwatch(https://nightwatchjs.org/)は、内部的にWebDriver API(https://www.w3.org/TR/webdriver/)を利用しており、ブラウザに文字を入力する、ボタンをクリックする、ページを遷移する、などといった操作の仕組みを標準で備えている。

Nightwatchをインストールした場合、Vue CLIのプロジェクトには以下のようなフォルダ／ファイルが追加される。

```
root (プロジェクトルート)
 └─ tests
      └─ e2e
          ├─ custom-assertions
          │        └─ elementCount.js   追加のアサーション      
          └─ specs
               └─ test.js   既定で用意されたテストコード
```

Nightwatchそのものの設定は、Vue CLIのNightwatchプラグインが既定で用意している。特別な設定なく、テストを実施できる。

#### テストコードの基本

既定で用意されたテストコードを読み解く。

```test.js
module.exports = {
    'default e2e tests': browser => {
        browser
            .url(process.env.VUE_DEV_SERVER_URL)
            .waitForElementVisible('#app', 5000)
            .assert.elementPresent('.hello')
            .assert.containsText('h1', 'Welcome to Your Vue.js App')
            .assert.elementCount('img', 1)
            .end()
    }
}
```

テストコードは、`module.exports = {...}`の配下に記述するのが基本。`module.exports`はNode.jsのモジュール定義の構文だが、Nightwatchではこれをひとつのテストスイートとして扱う。
個々のテストケースは、配下のメソッドとして表す。テストケースは必要に応じて複数列記しても構わない。

```
'name': browser => { test }

name: テストケースの名前
test: テストコード
```

引数browserはNightwatchオブジェクトで、ブラウザ操作、テスト実施のためのメソッドを提供する。urlメソッドは、その中でもよく利用する機能で、指定されたURLにアクセスしてページを開く。
その他、browserオブジェクト経由でアクセスできるメソッドには、以下の表のようなものがある。

分類 | メソッド | 概要
--- | --- | ---
基本 | url(url) | 指定のページに移動
基本 | back() | ひとつ前のページに戻る
基本 | forward() | ひとつ次のページに進む
基本 | refresh()) | 現在のページを更新
基本 | end() | セッションを終了
要素 | waitForElementVisible(selector, wait) | 指定の要素が有効になるまでwaitミリ秒待機
要素 | waitForElementPresent(selector, wait) | 指定の要素が存在するかをwaitミリ秒待機
要素 | element(selector) | セレクターに合致する要素を取得
要素　| title() | 現在のページタイトルを取得
マウス、キーボード | click(selector) | 指定された要素をクリック
マウス、キーボード | setValue(selector, value) | 指定された入力要素に値を設定
マウス、キーボード | clearValue(selector) | 指定された入力要素の値をクリア
マウス、キーボード | submit(id) | 指定のフォームをサブミット

ページの内容を検証するのは、assertメソッドの役割。`assert.name(...)`の形式で表す。nameには、以下のようなアサーションメソッドを指定できる。

メソッド | 概要
--- | ---
attributeEquals(elem, attr, expected [,msg]) | 要素elemの属性attrに期待値expectedが含まれているか
attributeEquals(elem, attr, expected [,msg]) | 要素elemの属性attrが期待値expectedと等しいか
containsText(elem, text, [,msg]) | 要素elemが指定のテキストtextを含むか
cssClassPresent(elem, clazz, [,msg]) | 要素elemが指定のクラスclazzを持っているか
cssClassNotPresent(elem, clazz, [,msg]) | 要素elemが指定のクラスclazzを持っていないか
cssProperty(elem, prop, expected [,msg]) | 要素elemのcssプロパティpropが期待値expectedを持っているか
elementPresent(elem, [,msg]) | 指定の要素elemが存在するか
elementNotPresent(elem, [,msg]) | 指定の要素elemが存在しないか
hidden(elem [,msg]) | 要素elemが非表示状態か
title(expected [,msg]) | ページタイトルが指定の値expectedと等しいか
urlContains(expected [,msg]) | URLに指定の値expectedが含まれているか
urlEquals(expected [,msg]) | URLが指定の値expectedと等しいか
value(elem, expected [,msg]) | 要素elemの値が期待値expectedと等しいか
valueContains(elem, expected [,msg]) | 要素elemの値が期待値expectedを含んでいるか
visible(elem [,msg]) | 要素elemが表示されているか

すべてのアサートが完了したら、最後にendメソッドでブラウザを閉じて、テストを終了する。

#### E2Eテストの実行

Vue CLI環境でE2Eテストを実行するには、`npx vue-cli-service test:e2e`コマンドを実行する。
テストスイート内の、waitForElementVisibleを含むすべてのアサートが成功したことが確認できる。
テスト失敗の場合も、test.jsをあえて失敗するように書き換えておく。

`.assert.elementPresent('.bye')`

`npx vue-cli-service test:e2e`でテストを再実行し、失敗結果を確認する。
失敗したアサートが通知され、テストが中断していることが確認できる。
アサートが失敗したときに中断せずに、そのまま後続のアサートを実施する場合には、`.assert`の代わりに`.verify`を利用する。

`.verify.elementPresent('.bye')`

アサート失敗の後もテストは継続することが確認できる。

##### --test、--filterオプション

--test、--filterオプションを利用することで特定のテストスイートだけを実行することも可能。

```
> npx vue-cli-service test:e2e --test ./tests/e2e/specs/test.js

> npx vue-cli-service test:e2e --filter test*.js
```

#### expectアサーション

Nightwatchでは、assertアサーションともうひとつ、expectアサーションも標準で提供している。
assertに比べると、より英文に近い感覚で読めるメリットがある。assertのようにアサートを連結できない、カスタムのエラーメッセージを設定できない、などの制約もあるが、テストコードがそのまま自然言語に近い仕様を表せるというメリットは得難いもの。
expectアサーションの一般的な構文は以下のとおり。

```
browser.expect.eement(selector).name(...)

selector: セレクター
name: アサーション
```

利用できるアサーションには、以下の表のようなものがある。

分類 | メソッド | 概要
文字列 | equal(value) | 指定された値と等しいか
文字列 | contain(value) | 指定された値を含むか
文字列 | match(regex) 指定された正規表現にマッチするか
文字列 | startsWith(value) | 指定された値で開始するか
文字列 | endsWith(value) | 指定された値で終了するか
要素、属性 | a(type)、an(type) | 要素が指定の型であるか
要素、属性 | attribute(name) | 指定された属性が存在するか
要素、属性 | css(prop) | 指定されたスタイルプロパティが存在するか
状態 | enabled | 要素が有効な常態か
状態 | visible | 要素が表示状態にあるか
状態 | present | 要素が存在するか
状態 | selected | 選択状態にあるか (option)
取得 | text | 配下のテキストを取得
取得 | value | 要素の値を取得
その他 | not | 後続のアサーションを否定
その他 | before(ms) | 指定された時間(ミリ秒)で再試行

expectアサーションでは、コードの読みやすさのためだけに用意されたLanguage Chainsと呼ばれるメソッドもある。
指定できるのは以下のもの。これらはアサーション機能を持つものではなく、記述の順番も関係ない。

* to
* be
* been
* is
* that
* which
* and
* has
* have
* with
* at
* does
* of

これらのexpectアサーションを利用して作成したテストコード。
テスト対象はVue Routerを利用したページ移動を伴うアプリ。

```test.js
module.exports = {
    'Router tests': browser => {
        browser
        .url(process.env.VUE_DEV_SERVER_URL)
        .pause(1000)
        // id="app"である要素が存在するか
        browser.expect.element('#app').to.be.present.before(1000)
        // Aboutページへのリンクをクリック
        browser
        .click('a[href="/about"]')
        .pause(1000)
        // id="name"である要素が「class="search"」属性を持つか
        browser.expect.element('#name').to.have.attribute('class')
            .which.contains('search')
        // テキストボックスへの入力&ボタンクリック(結果を検証)
        browser
            .setValue('#name', '山田')
            .click('#send')
        browser.expect.element('#result').text
            .to.equal('こんにちは、山田さん！')
        // 終了
        browser.end()
    }
}
```

Language Chainsにあたるメソッドは省略しても挙動には影響しない。

