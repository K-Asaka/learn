import ReactDOM from 'react-dom/client';
import TitledPanel from './TitledPanel';
// アプリ固有のコードをインポート
import './index.css';

// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
const title = <p>メンバー募集中！</p>
const body = <p>ようこそ、WINGSプロジェクトへ！！</p>
root.render(
  <TitledPanel title={title} body={body}></TitledPanel>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
