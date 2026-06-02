import { Outlet, ScrollRestoration } from 'react-router-dom';

export default function RouterScroll() {
    return (
        <>
            <ScrollRestoration getKey={(location, matches) => location.key} />
            <Outlet />
        </>
    );
}
