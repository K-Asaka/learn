import { useReducer } from 'react';

// Propsの型定義
type HookReducerUpProps = {
    init: number
};

// Stateの型定義
type StateType = {
    count: number;
};

// Actionの型定義
type ActionType = {
    type: 'update',
    step: number
} | {
    type: 'reset',
    init: number
};

// Reducerの型定義
type CountReducerType = (state: StateType, action: ActionType) => StateType;

export default function HookReducerUp({ init }: HookReducerUpProps) {
    // Reducerへの型付け
    const [state, dispatch] = useReducer<CountReducerType>(
        // Reducerの実体
        (state, action) => {
            switch (action.type) {
                case 'update':
                    return { count: state.count + action.step };
                case 'reset':
                    return { count: action.init };
                default:
                    return state;
            }
        },
        // Stateの初期値
        {
            count: init
        }
    );

    const handleUp = () => dispatch({ type: 'update', step: 1 });
    const handleDown = () => dispatch({ type: 'update', step: -1 });
    const handleReset = () => dispatch({ type: 'reset', init: 0 });

    return (
        <>
            <button onClick={handleUp}>カウントアップ</button>
            <button onClick={handleDown}>カウントダウン</button>
            <button onClick={handleReset}>リセット</button>
            <p>{state.count}回、クリックされました。</p>
        </>
    );
}
