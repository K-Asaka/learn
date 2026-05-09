import { useState } from 'react';

export default function FormCheck() {
    // Stateを初期化
    const [form, setForm] = useState({
        agreement: true
    });

    // チェックボックスの変更時に入力値をStateに反映
    const handleFormCheck = e => {
        setForm({
            ...form,
            [e.target.name]: e.target.checked
        });
    };

    // [送信]ボタンクリックで入力値をログ出力
    const show = () => {
        console.log(`同意確認：${form.agreement ? '同意' : '反対'}`);
    };

    return (
        <form>
            <label htmlFor="agreement">同意します：</label>
            <input id="agreement" name="agreement" type="checkbox"
                checked={form.agreement}
                onChange={handleFormCheck} /><br />
            <button type="button" onClick={show}>送信</button>
        </form>
    );
}
