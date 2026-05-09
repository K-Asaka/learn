import { useState } from 'react';

export default function FormSelect() {
    // Stateを初期化
    const [form, setForm] = useState({
        animal: 'dog'
    });

    // 選択ボックスの変更時に入力値をStateに反映
    const handleForm = e => {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });
    };

    // [送信]ボタンクリックで入力値をログ出力
    const show = () => {
        console.log(`好きな動物：${form.animal}`);
    };

    return (
        <form>
            <label htmlFor="animal">好きな動物：</label>
            <select id="animal" name="animal"
                value={form.animal}
                onChange={handleForm}>
                <option value="dog">イヌ</option>
                <option value="cat">ネコ</option>
                <option value="hamster">ハムスター</option>
                <option value="rabbit">ウサギ</option>
            </select>
            <button type="button" onClick={show}>送信</button>
        </form>
    );
}
