// ロゴ／スタイルシートをインポート
import logo from './logo.svg';
import './App.css';

// Appコンポーネントを定義
function App() {
  // 描画内容を生成
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          こんにちは、React！！
        </a>
      </header>
    </div>
  );
}

// App関数をデフォルトエクスポート
export default App;
