import { useReducer } from 'react';

// 引数に基づいて0～initの間の値を生成
function initCounter(init) {
    console.log('initCounter is called!!');
    return {
        count: Math.floor(Math.random() * (init + 1))
    };
}

export default function HookReducerInit({ init }) {
    const [state, dispatch] = useReducer(
        (state, action) => {
            switch (action.type) {
                case 'update':
                    return { count: state.count + 1 };
                default:
                    return state;
            }
        },
        initCounter(init),
    );

    // Reducer経由でStateを更新
    const handleClick = () => {
        dispatch({ type: 'update' });
    };
    return (
        <>
            <button onClick={handleClick}>カウント</button>
            <p>{state.count}回、クリックされました。</p>
        </>
    );
}
