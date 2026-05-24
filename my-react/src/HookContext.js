import { createContext } from 'react';
import { HookContextChild } from './HookContextChild';

// コンテキストを初期化
export const MyAppContext = createContext();
// コンテキストに渡すためのオブジェクトを準備
const config = {
    title: 'React入門',
    lang: 'ja-JP',
};

export default function HookContext() {
    // 配下の要素に対してコンテキストを適用
    return (
        <MyAppContext.Provider value={config}>
            <div id="c_main">
                <HookContextChild />
            </div>
        </MyAppContext.Provider>
    );
}
