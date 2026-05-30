import { useState, useTransition } from 'react';
import books from './books';
import commentList from './comments';
import { BookDetails, CommentList } from './HookTransitionChild';

export default function HookTransition() {
    // 選択された書籍(isbn)と対応するコメント(comments)
    const [isbn, setIsbn] = useState('');
    const [comments, setComments] = useState([]);
    // トランジションを利用するための準備
    const [isPending, startTransition] = useTransition();

    // 選択ボックスの変更に応じてStateを反映
    const handleChange = e => {
        const isbn = e.target.value;
        setIsbn(isbn);
        // トランジションの配下でStateを更新する
        startTransition(() => {
            setComments(commentList.filter(c => c.isbn === isbn));
        });
    };

    return (
        <>
            <select onChange={handleChange}>
                <option value="">選択してください。</option>
                {books.map(b => (
                    <option key={b.isbn} value={b.isbn}>{b.title}</option>
                ))}
            </select>
            <BookDetails isbn={isbn} />
            <hr />
            <CommentList src={comments} isPending={isPending} />
        </>
    );
}
