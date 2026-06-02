import { render, screen, waitFor } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import StateBasic from './StateBasic';

test('StateBasic Test', async () => {
    // userEventオブジェクトを生成
    const ev = userEvent.setup();
    render(<StateBasic init={0} />);
    // 操作対象の要素を取得
    const btn = screen.getByRole('button', { name: 'カウント' });
    const cnt = screen.getByText(/クリック/);
    // ボタンをクリック
    ev.click(btn);
    await waitFor(() => { expect(cnt).toHaveTextContent('1回'); });
});
