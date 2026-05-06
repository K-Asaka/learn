import Download from './Download';

export default function ForItem({ book }) {
    return (
        <>
            <dt>
                <a href={`https://wings.msn.to/books/${book.isbn}/${book.isbn}.jpg`}>
                    {book.title} ({book.price}円)
                </a>
            </dt>
            <dd>
                {book.summary}
                {book.download ? <Download isbn={book.isbn} /> : null}
            </dd>
        </>
    );
}
