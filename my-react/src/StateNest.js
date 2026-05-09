import { useState } from 'react';

export default function StateNest() {
    // 入れ子の配列をStateとして宣言
    const [form, setForm] = useState({
        name: '山田太郎',
        address: {
            prefecture: '広島県',
            city: '榛原町'
        }
    });

    // 1段目の要素を更新するためのハンドラー
    const handleForm = e => {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });
    };

    // 2段目の要素を更新するためのハンドラー
    const handleFormNest = e => {
        setForm({
            ...form,
            address: {
                ...form.address,
                [e.target.name]: e.target.value
            }
        });
    };

    // [送信]ボタンのクリックでフォーム情報をログに出力
    const show = () => {
        console.log(`${form.name} (${form.address.prefecture}・${form.address.city})`);
    };

    return (
        <form>
            <div>
                <label htmlFor="name">名前：</label>
                <input id="name" name="name" type="text"
                    onChange={handleForm} value={form.name} />
            </div>
            <div>
                <label htmlFor="prefecture">住所（都道府県）：</label>
                <input id="prefecture" name="prefecture" type="text"
                    onChange={handleFormNest} value={form.address.prefecture} />
            </div>
            <div>
                <label htmlFor="city">住所（市町村）：</label>
                <input id="city" name="city" type="text"
                    onChange={handleFormNest} value={form.address.city} />
            </div>
            <div>
                <button type="button" onClick={show}>
                    送信
                </button>
            </div>
        </form>
    );
}
