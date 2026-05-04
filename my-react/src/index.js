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
const tag = (
  // コメントです（JSX式内でないのでOK）
  <ul>
    {/* コメントです。 */}
    <li // タグ内ではOK
      >React</li>
    <li /*
      これも大丈夫
    */>Vue.js</li>
    // 子要素での「//」「/* ～ */」はダメ
    <li>Angular</li>
  </ul>
);
root.render(
  <>
    {tag}
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
