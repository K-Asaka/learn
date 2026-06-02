import { render, screen } from '@testing-library/react';
import App from './App';

// テストケースを定義
test('renders learn react link', () => {
  // コンポーネントを描画
  render(<App />);
  // テスト対象の要素を検索＆取得
  const linkElement = screen.getByText(/learn react/i);
  // 描画結果が正しいかを検証
  expect(linkElement).toBeInTheDocument();
});
