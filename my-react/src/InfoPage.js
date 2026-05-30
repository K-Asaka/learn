import { Link } from 'react-router-dom';

export default function InfoPage() {
    return (
        <>
            <p>Infoページです。</p>
            <Link to=".." relative="path">トップ</Link>
        </>
    );
}
