import ReactDOM from 'react-dom/client';
import React, { Suspense } from 'react';
import { ErrorBoundary } from 'react-error-boundary';
import { QueryClient, QueryClientProvider } from 'react-query';
import QuerySuspense from './QuerySuspense';
// アプリ固有のコードをインポート
import './index.css';

// パフォーマンス監視のためのサービスをインポート
import reportWebVitals from './reportWebVitals';

// Reactアプリ（Appコンポーネント）を描画
const root = ReactDOM.createRoot(document.getElementById('root'));
// Suspenseモードを有効化
const cli = new QueryClient({
  defaultOptions: {
    queries: {
      suspense: true,
    },
  },
});

root.render(
  <Suspense fallback={<p>Loading...</p>}>
    <ErrorBoundary fallback={<div>エラーが発生しました</div>}>
      <QueryClientProvider client={cli}>
        <QuerySuspense />
      </QueryClientProvider>
    </ErrorBoundary>
  </Suspense>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// パフォーマンス監視ツールを有効化
reportWebVitals(console.log);
