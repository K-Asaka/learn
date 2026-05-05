// React関連のライブラリをインポート
import React from 'react';
import ReactDOM from 'react-dom/client';
// アプリ固有のコードをインポート
import './index.css';
import App from './App';
// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
// あまりよくない例
const attrs = {
  href: 'https://wings.msn.to/',
  download: false,
  target: '_blank',
  rel: 'help'
};

root.render(
  <>
    <a href={attrs.href} download={attrs.dwnload}
      target={attrs.target} rel={attrs.rel}>サポートページへ</a><br />
    {/* スプレッド構文を用いるとオブジェクトを個々の属性に展開できる */}
    <a {...attrs}>サポートページへ</a>
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
