import { useLocation } from 'react-router-dom';

export default function BookStatePage() {
    // Locationオブジェクトを取得
    const { state: isbn = '978-4-8156-0182-9' } = useLocation();

    return (
        <>
            <p>ISBNコード「{isbn}」のページです。</p>
        </>
    );
}
