import ReactDOM from 'react-dom/client';
import MyHello from './MyHello';
// アプリ固有のコードをインポート
import './index.css';

// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <>
    <MyHello myName={13} />
    <MyHello myName={['山田', '鈴木', '佐藤']} />
    <MyHello myName={() => { console.log('Hoge'); }} />
    {/* <MyHello myName={{ name: '鈴木', age: 48 }} /> */}
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
