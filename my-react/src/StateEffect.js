import { useEffect, useState } from 'react';

export default function StateEffect({ init }) {
    const [count, setCount] = useState(init);
    const [hoge, setHoge] = useState('hoge');
    // State値(count)が変化した場合にだけログを表示
    useEffect(() => {
        console.log(`count is ${count}.`);
    }, [count]);
    const handleClick = () => setCount(count + 1);

    return (
        <>
            {/* ボタンにタイムスタンプ値を反映 */}
            <button onClick={() => setHoge(Date.now())}>Hoge ({hoge})</button>
            <button onClick={handleClick}>カウント</button>
            <p>{count}回、クリックされました。</p>
        </>
    );
}
