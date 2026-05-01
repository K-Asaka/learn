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

