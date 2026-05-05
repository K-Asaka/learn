// React関連のライブラリをインポート
import React from 'react';
import ReactDOM from 'react-dom/client';
// アプリ固有のコードをインポート
import './index.css';

// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
const title = 'これからはじめるVue.js 3実践入門';

root.render(
  /*
  <div className="main">
    <p>「{title}」　（SBクリエイティブ刊）</p>
    <img src="https://wings.msn.to/books/978-4-8156-1336-5/978-4-8156-1336-5.jpg"
      alt={title} />
    絶賛発売中！
  </div>
  */
  // 上位の<div>要素を生成
  React.createElement(
    'div',
    { className: 'main' },
    // 子要素の<p>、<img>、テキストを列挙
    React.createElement(
      'p',
      null, // 属性は省略
      `「${title}」　（SBクリエイティブ刊）`
    ),
    React.createElement(
      'img',
      {
        src: 'https://wings.msn.to/books/978-4-8156-1336-5/978-4-8156-1336-5.jpg',
        alt: title
      }
    ),
    '絶賛発売中！'
  )
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
