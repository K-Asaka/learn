import { useDeferredValue, useState } from 'react';

export default function HookDeferred() {
    const [text, setText] = useState('');
    // 変数textの遅延バージョンを生成
    const deferText = useDeferredValue(text);
    // テキストボックスを変更したときに、text/deferText双方をログ表示
    const handleChange = e => {
        setText(e.target.value);
        console.log(text, deferText);
    };

    return (
        <>
            <input type="text" value={text} onChange={handleChange} />
            {[...Array(10000)].map((e, index) => <p key={index}>{deferText}</p>)}
        </>
    );
}
