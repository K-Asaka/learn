import { memo } from 'react';

// カウンターを増減するためのボタン
// id: id値、handleClick: ボタンのハンドラー、children: ボタンキャプション
export const MyButton = memo(({ id, handleClick, children }) => {
    // 再描画時にログ
    console.log(`MyButton is called: ${id}`);
    return (
        <button onClick={handleClick}>{children}</button>
    );
});

// カウンター値を表示するためのラベル
// id: id値、value: 表示する値
export const MyCounter = memo(({ id, value }) => {
    // 再描画時にログ
    console.log(`MyCounter is called: ${id}`);
    return (
        <p>現在値：{value}</p>
    );
});
