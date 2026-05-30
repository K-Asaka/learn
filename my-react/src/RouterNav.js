import { NavLink, Outlet } from 'react-router-dom';
import './RouterNav.css';

const isCurrent = ({ isActive, isPending }) => isActive ? 'active' : '';

export default function RouterNav() {
    return (
        <>
            <ul>
                <li><NavLink className={isCurrent} to="/">トップ</NavLink></li>
                <li><NavLink className={isCurrent} to="/article">公開記事</NavLink></li>
                <li><NavLink className={isCurrent} to="/about">このサイトについて</NavLink></li>
            </ul>
            <hr />
            <Outlet />
        </>
    );
}
