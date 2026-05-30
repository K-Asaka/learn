import { useParams } from 'react-router-dom';

export default function BookPage() {
    // ルートパラメーターを取得
    const params = useParams();
    return <p>ISBNコード「{params.isbn}」のページです。</p>;
}
