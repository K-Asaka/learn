import HookThemeButton from './HookThemeButton';
import MyThemeProvider from './MyThemeProvider';
import { render, screen, waitFor } from '@testing-library/react';
import userEvent from '@testing-library/user-event';

test('HookThemeButton Test', async () => {
    const ev = userEvent.setup();
    // MyThemeProvider付きで、HookThemeButtonを描画
    render(<HookThemeButton />, { wrapper: MyThemeProvider });
    // ボタンクリックをシミュレート
    const btn = screen.getByRole('button');
    ev.click(btn);
    // ボタンキャプションがdarkに変化していることを確認
    await waitFor(() => expect(btn).toHaveTextContent('dark'));
});
