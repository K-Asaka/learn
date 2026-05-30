import { useReducer } from 'react';

export default function useCounter(init, step) {
    // カウンターを管理するためのState/Reducerを準備
    const [state, dispatch] = useReducer(
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
        {
            count: init
        }
    );
    // それぞれのボタンに対応したハンドラー
    const handleUP = () => dispatch({ type: 'update', step });
    const handleDown = () => dispatch({ type: 'update', step: -step });
    const handleReset = () => dispatch({ type: 'reset', init });
    return [state, handleUP, handleDown, handleReset];
}
