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
root.render(
  <>
    <div>{'Tom \u0026 Jerry'}</div>
    <div>{`Tom ${String.fromCodePoint(38)} Jerry`}</div>
    <div dangerouslySetInnerHTML={{__html: 'Tom &amp; Jerry'}} />
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
