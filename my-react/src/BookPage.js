import { useParams } from 'react-router-dom';
import MyHeader from './MyHeader';
import books from './books';

export default function BookPage() {
    const { isbn = '978-4-8156-0182-9' } = useParams();
    // ISBNコードの形式に則っていなければエラー
    if (!/978-4-[0-9]{2,7}-[0-9]{2,7}-[0-9X]/.test(isbn)) {
        throw new RangeError('ISBN is invalid!!');
    }

    return <p>ISBNコード「{isbn}」のページです。</p>;
}
