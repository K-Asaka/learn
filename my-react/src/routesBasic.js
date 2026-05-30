// React Router本体をインポート
import { createBrowserRouter } from 'react-router-dom';
// ルーティングで利用するページをインポート
import TopPage from './TopPage';
import ArticlePage from './ArticlePage';
import AboutPage from './AboutPage';

// ルーティングテーブルを定義
const routesBasic = createBrowserRouter([
    { path: '/', element: <TopPage /> },
    { path: '/article', element: <ArticlePage /> },
    { path: '/about', element: <AboutPage /> },
]);

export default routesBasic;
