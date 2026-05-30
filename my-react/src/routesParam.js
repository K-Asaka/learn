import { Route, createBrowserRouter, createRoutesFromElements } from 'react-router-dom';
import RouterParam from './RouterParam';
import TopPage from './TopPage';
import BookPage from './BookPage';
import SearchPage from './SearchPage';


const routesParam = createBrowserRouter (
    createRoutesFromElements(
        <Route element={<RouterParam />}>
            <Route path="/" element={<TopPage />} />
            <Route path="/book/:isbn?" element={<BookPage />} />
            {/* 可変長パラメーターを定義 */}
            <Route path="/search/*" element={<SearchPage />} />
        </Route>
    )
);

export default routesParam;
