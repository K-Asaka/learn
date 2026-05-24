import { useReducer } from 'react';

export default function HookReducer({ init }) {
    // State+Reducerの準備
    const [state, dispatch] = useReducer(
        // Reducer関数
        (state, action) => {
            switch (action.type) {
                case 'update':
                    return { count: state.count + 1 };
                default:
                    return state;
            }
        },
        // Stateの初期化
        {
            count: init
        }
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
