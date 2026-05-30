import { Route, createBrowserRouter, createRoutesFromElements } from 'react-router-dom';
import RouterParam from './RouterParam';
import TopPage from './TopPage';
import BookPage from './BookPage';


const routesParam = createBrowserRouter (
    createRoutesFromElements(
        <Route element={<RouterParam />}>
            <Route path="/" element={<TopPage />} />
            <Route path="/book/:isbn" element={<BookPage />} />
        </Route>
    )
);

export default routesParam;
