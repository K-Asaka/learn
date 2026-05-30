import { Route, createBrowserRouter, createRoutesFromElements } from 'react-router-dom';
import RouterApp from './RouterApp';
import TopPage from './TopPage';
import ArticlePage from './ArticlePage';
import AboutPage from './AboutPage';

const routesLink = createBrowserRouter(
    createRoutesFromElements(
        <>
        {/* トップルーツを追加 */}
        <Route path="/" element={<RouterApp />}>
            <Route path="" element={<TopPage />} />
            <Route path="article" element={<ArticlePage />} />
            <Route path="about" element={<AboutPage />} />
        </Route>
        </>
    )
);

export default routesLink;
