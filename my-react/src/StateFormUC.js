import { useRef } from 'react';

export default function StateFormUC() {
    // React要素への参照を準備
    const name = useRef(null);
    const age = useRef(null);
    // 要素(参照)経由で入力値を準備
    const show = () => {
        console.log(`こんにちは、${name.current.value} (${age.current.value} 歳) さん！`);
    };
    // フォームを描画
    return (
        <form>
            {/* 準備した参照を各要素に紐づけ */}
            <div>
                <label htmlFor="name">名前：</label>
                <input id="name" name="name" type="text"
                    ref={name} value="佐藤理央" />
            </div>
            <div>
                <label htmlFor="age">年齢：</label>
                <input id="age" name="age" type="number"
                    ref={age} value="18" />
            </div>
            <div>
                <button type="button" onClick={show}>
                    送信
                </button>
            </div>
        </form>
    );
}
