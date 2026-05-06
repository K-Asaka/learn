import ReactDOM from 'react-dom/client';
//import books from './books';
import ForNest from './ForNest'
// アプリ固有のコードをインポート
import './index.css';

// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
const books = [];
root.render(
  <>
  <ForNest src={books} />
  <p>{books.length && `${books.length}件のデータがあります。`}</p>
  <p>-----</p>
  <p>{books.length > 0 && `${books.length}件のデータがあります。`}</p>
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
