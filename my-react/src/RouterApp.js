import { Link, Outlet } from 'react-router-dom';

export default function RouterApp() {
    return (
        <>
            <ul>
                {/* ルーティング対応のリンクを生成 */}
                <li><Link to="/">トップ</Link></li>
                <li><Link to="/article">公開記事</Link></li>
                <li><Link to="/about" replace>このサイトについて</Link></li>
                <li><Link to="/article/info">Infoページ</Link></li>
            </ul>
            <hr />
            <Outlet />
        </>
    );
}
