import ReactDOM from 'react-dom/client';
import TypeProp, { Member } from './TypeProp';
// アプリ固有のコードをインポート
import './index.css';

// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // 正しい例
  //<TypeProp prop5={{ '鈴木花子': 15, '佐藤雫': 30 }} />
  // 誤った例
  <TypeProp prop5={{ '鈴木花子': 15, '佐藤雫': '三十' }} />
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
