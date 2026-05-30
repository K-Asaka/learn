import { Link } from 'react-router-dom';

export default function InfoPage() {
    return (
        <>
            <p>Infoページです。</p>
            <Link to="/" reloadDocument>トップ</Link>
        </>
    );
}
