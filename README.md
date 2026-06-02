# 学習記録用リポジトリ

## これからはじめるReact実践入門

- Reactの本家サイト
[ https://ja.react.dev/ ]


### Create React App

Reactアプリを開発するためのコマンドラインツール。

- トランスパイラー
  - JSX(JavaScript XML)拡張構文をピュアなJavaScriptに変換する
  - Babel [ https://babeljs.io ]
- バンドラー
  - モジュールをひとつに束ねる処理をバンドル(bundle)と言い、バンドルを担うツール
  - webpack [ https://webpack.js.org/ ]
  - ミニフィケーション
    - コメントや空白を除去したり、ローカル変数の名前を短縮化するなど、コードそのもののサイズを最小化すること
  - ダイジェスト付与
    - 最終的に生成されるファイル名の末尾に、main.d0f9839a.jsのようにハッシュ値(ダイジェスト)を付与する
    - ブラウザーの意図しないキャッシュを防ぐ
- ノーバンドルツール
  - 開発時にはバンドルせず、モジュール個々のインポートをブラウザーに委ねるようなツール
  - Vite(ヴィート)
- 開発サーバー
  - Webアプリは一般的にはサーバー上に置かれ、クライアント(ブラウザー)からのリクエストに応じて配信される
  - HTTPサーバー
  - Create React Appでもwebpack-dev-serverという簡易サーバーが用意されている


### Node.jsのインストール

Node.js [ https://nodejs.org ]


### Visual Studio Codeのインストール

VSCode [ https://code.visualstudio.com/Download ]


#### 拡張機能のインストール

- ESLint：JavaScriptの静的コード解析ツール
- Live Servre：ローカルなWebサーバー


### コンバーターの活用

- Transform [ https://transform.tools/html-to-jsx ]


## コンポーネント開発

### コンポーネントとは

ページを構成するUI部品のこと。
テンプレート(見た目)と、それに付随するロジックから構成される。


## Props / State

いずれもコンポーネントで値を扱うためのしくみ。
目的が異なる。
Propsがコンポーネントにパラメーターを渡すための引数であるとするならば、Stateはコンポーネント内の状態を表す変数。
コンポーネントでは、Propsで外から値を受け取り、以降は刻々と変化していく状態をStateで管理していくのが基本。
関数のキーワードで表現するならば、Propsが仮引数、Stateがローカル変数と言い換えてもよい。


## React Developer Tools

Chrome、Edge、Firefoxに対応している。

- Chrome [ https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi ]
- Edge [ https://microsoftedge.microsoft.com/addos/detail/react-developer-tools/gpphkfbcpidddadnkolkpfckpihlkkil ]
- Firefox [ https://addons.mozilla.org/en-US/firefox/addon/react-devtools/ ]


### Safari環境

1. react-devtoolsパッケージをインストールする
    - `% npm install -g react-devtools`
2. 開発者ツールを起動する
    - `% react-devtools`
    - コマンドが見つからない場合はパスを通す
        - `% export PATH=$PATH:/Users/＜ユーザー名＞/.npm-global/bin`
3. ページに\<script\>要素を追加する
    ```<!DOCTYPE html>
        <html lang="en">
        <head>
            …中略…
            <script src="http://localhost:8097"></script>
            <title>React App</title>
        </head>
        …中略…
        </html>
    ```


## PropTypes

PropTypesを利用する際の最低限のルール。

1. prop-typesモジュールをあらかじめインポートしておく
2. 「コンポーネント名.propTypes」に対して、「プロパティ名：型情報」の形式で型定義を渡す
3. 型定義はexport宣言よりも前

| 型 | 概要 |
| :---: | :--- |
| PropTypes.string | 文字列型 |
| PropTypes.symbol | シンボル型 |
| PropTypes.number | 数値型 |
| PropTypes.bool | 真偽型 |
| PropTypes.array | 配列(要素の型は任意) |
| PropTypes.object | オブジェクト型(要素の型は任意) |
| PropTypes.func | 関数型 |
| PropTypes.element | React要素 |
| PropTypes.node | element、number、string、arrayのいずれか |
| PropTypes.any | 任意の型 |


## コンポーネントの描画時間を計測する - Profilerコンポーネント

本番環境では既定で無効となる。
本番環境にプロファイリング機能を付与するには、ビルド時に`--profile`オプションを付与する。

`> npm run build -- --profile`


## コンポーネント開発でのスタイル定義

### JSX式にスタイルシートを埋め込む

#### Styled JSXのインストール方法

```
> npm install styled-jsx
> npm run eject
```

`eject`で個々の設定ファイルが展開される。`package.json`を開き、`babel`キーを編集する。

```
{
  …中略…
  "babel": {
    "presets": [
      "react-app"
    ],
    "plugins": [
      "styled-jsx/babel"
    ]
  }
}
```

#### EjectしないでStyled-JSXを利用する

設定ファイルのEjectは一方向の(元に戻せない)操作のため、既存プロジェクトへの影響も大きい。
以下の手順を踏むことで、EjectせずにStyled JSXを有効にすることができる。
Styled JSXをインストール後、以下の手順を実行する。

1. act-app-rewiredとcustomize-craをインストールする  
  Create React Appのバンドル構成を上書きするためのライブラリ。  
  `> npm install react-app-rewired customize-cra --save-dev`
2. package.jsonを編集する  
  アプリを`react-app-rewired`経由でビルドするために、`start`、`build`、`test`コマンドを書き換える。
  以下は`start`の書き換え例。
  ```
  "scripts": {
    "start": "react-app-rewired start",
    …中略…
  },
  ```
3. プロジェクトルートに設定ファイルを作成する  
  設定情報を上書きするために、`config-overrides.js`をプロジェクトルートに作成する。
  ```
  const { addBabelPlugins, override } = require("customize-cra");
  module.exports = override(
    ...addBabelPlugins(
      "styled-jsx/babel"
    )
  );
  ```

### 外部サービスからデータを取得する

OpenWeater API  
[ https://openweathermap.org/current ]  

サインアップページ  
[ https://home.openweathermap.org/users/sign_up ]


### OpenWeather APIの基本

[ https://api.openweathermap.org/data/2.5/weather?lat=35.6895&lon=139.692&appid={API_KEY} ]


### React Routerアプリを本番環境に移行する場合

「http://example.com/about」のようなルート上のパスに、直接アクセスした場合、サーバー上には/aboutというフォルダ／ファイルが存在しないため`404 Not Found`エラーを返す。  
Apache HTTP Serverでは`/public`フォルダは以下に、`.htaccess`を用意する。
指定のリソースが存在しない場合は`index.html`にリダイレクトする。

```Apache:.htaccess
RewriteEngine On
RewriteCond %{REQUEST_FILENAME} !-f
RewriteCond %{REQUEST_FILENAME} !-d
RewriteRule ^ index.html [QSA,L]
```


### 単体テスト

- テストを実行する
  - `npm run test MyUtil.test.js`
- watchモード
  - `npm run test -- --watchAll=false`
- コードカバレッジ分析の結果をレポートする
  - `npm run test -- --coverage --watchAll=false`
  - プロジェクトルートの配下から`/coverage/lcov-report/index.html`を開く

