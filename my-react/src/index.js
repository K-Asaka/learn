import ReactDOM from 'react-dom/client';
import EventMouse from './EventMouse';
// アプリ固有のコードをインポート
import './index.css';

// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <EventMouse
    alt="ロゴ画像"
    beforeSrc="https://www.web-deli.com/image/linkbanner_l.gif"
    afterSrc="https://www.web-deli.com/image/home_chara.gif" />
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
