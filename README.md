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

