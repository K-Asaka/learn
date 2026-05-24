import { useEffect, useLayoutEffect, useState } from 'react';

// delay秒だけ処理を休止するsleep関数
const sleep = delay => {
    const start = Date.now();
    // 現在時刻がstart(開始時刻)を超えるまでループを継続
    while (true) {
        if (Date.now() - start > delay) { break; }
    }
};

export default function HookEffect({ init }) {
    const [count, setCount] = useState(0);

    // 2000ミリ秒後にState(count)を設定
    useLayoutEffect(() => {
        sleep(2000);
        setCount(init);
    }, []);

    console.log(`count is ${count}`);
    // [カウント] ボタンクリック時にカウント値をインクリメント
    const handleClick = () => {
        setCount(c => c + 1);
    }
    return (
        <>
            <button onClick={handleClick}>カウント</button>
            <p>{count}回、クリックされました。</p>
        </>
    );
}
