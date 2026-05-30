import { useParams } from 'react-router-dom';

export default function BookPage() {
    // ルートパラメーターを取得
    const { isbn = '978-4-8156-0182-9' } = useParams();
    return <p>ISBNコード「{isbn}」のページです。</p>;
}
