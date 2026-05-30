import { NavLink, Outlet } from 'react-router-dom';
import './RouterNav.css';

export default function RouterParam() {
    return (
        <>
            <ul>
                <li><NavLink to="/">トップ</NavLink></li>
                <li><NavLink to="/book/978-4-8156-1336-5">
                    これからはじめるVue.js 3実践入門</NavLink></li>
                <li><NavLink to="/book/978-4-297-13288-0">
                    改訂3版 JavaScript本格入門</NavLink></li>
                <li><NavLink to="/book" end>既定の書籍</NavLink></li>
                <li><NavLink to="/search/react/router/remix">検索結果</NavLink></li>
            </ul>
            <hr />
            <Outlet />
        </>
    );
}
