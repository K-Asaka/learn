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
  //<TypeProp prop6={{ name: '鈴木花子', age: 35, sex: '女性', blood: 'A' }} />
  // 誤った例
  <TypeProp prop6={{ age: 35, sex: '女性' }} />
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
