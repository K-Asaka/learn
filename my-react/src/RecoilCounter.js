import { useRecoilState, useResetRecoilState } from 'recoil';
import { counterAtom } from './store/atom';

export default function RecoilCounter() {
    // Recoil管理下の値とセッターを取得
    const [counter, setCounter] = useRecoilState(counterAtom);
    // 以下と同等
    // const counter = useRecoilValue(counterAtom);
    // const setCounter = useSetRecoilState(counterAtom);
    const resetCounter = useResetRecoilState(counterAtom);

    const handleClick = () => {
        setCounter(c => c + 1);
    };

    return (
        <>
            <button onClick={handleClick}>カウント</button>
            <button onClick={() => resetCounter()}>リセット</button>
            <p>{counter}回、クリックされました。</p>
        </>
    );
}
