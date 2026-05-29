import { memo } from 'react';
import books from './books';

// delayミリ秒だけ処理を遅延するコード
const sleep = (delay) => {
    const start = Date.now();
    while (Date.now() - start < delay);
};

export function BookDetails({ isbn }) {
    const book = books.find(b => b.isbn === isbn);
    return (
        <ul>
            <li>ISBN：{book?.isbn}</li>
            <li>書名：{book?.title}</li>
            <li>価格：{book?.price}円</li>
            <li>概要：{book?.summary}</li>
            <li>配布サンプル：{(book?.download) ? 'あり' : 'なし'}</li>
        </ul>
    );
}

export const CommentList = memo(function({ src, isPending }) {
    // isPendingがtrueの場合はローディングメッセージを表示
    if (isPending) return <p>Now Loading...</p>;
    // 受け取ったコメント情報をリスト表示
    return (
        <ol>
            {src.map(c => <CommentItem key={c.id} src={c} />)}
        </ol>
    );
});

// 個々のコメント表示で時間のかかる処理をシミュレート
function CommentItem({ src }) {
    sleep(1000);
    return <li>{src.body} ({src.rank}) </li>;
}
