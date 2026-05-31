import { Route, createBrowserRouter, createRoutesFromElements } from 'react-router-dom';
import InvalidParamsPage from './InvalidParamsPage';
import RouterParam from './RouterParam';
import TopPage from './TopPage';
import BookPage from './BookPage';
import SearchPage from './SearchPage';
import NotFoundPage from './NotFoundPage';
import BookQueryPage from './BookQueryPage';
import BookStatePage from './BookStatePage';
import WeatherPage from './WeatherPage';

const routesParam = createBrowserRouter (
    createRoutesFromElements(
        <Route element={<RouterParam />}
            errorElement={<InvalidParamsPage />}>
            <Route path="/" element={<TopPage />} />
            <Route path="/book/:isbn?" element={<BookPage />} />
            <Route path="/bookQuery" element={<BookQueryPage />} />
            <Route path="/bookState" element={<BookStatePage />} />
            {/* 可変長パラメーターを定義 */}
            <Route path="/search/*" element={<SearchPage />} />
            <Route path="/weather/:city" element={<WeatherPage />}
                loader={({ params }) =>
                    fetch(`https://api.openweathermap.org/data/2.5/weather?q=${params.city}&lang=ja&appid={API_KEY}`)
                }/>
            {/* 任意のページに対応するルート */}
            <Route path="*" element={<NotFoundPage />} />
        </Route>
    )
);

export default routesParam;
