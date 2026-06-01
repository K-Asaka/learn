import { Route, createBrowserRouter, createRoutesFromElements,
    json, redirect } from 'react-router-dom';
// import InvalidParamsPage from './InvalidParamsPage';
import RouterParam from './RouterParam';
import TopPage from './TopPage';
import BookPage from './BookPage';
import SearchPage from './SearchPage';
import NotFoundPage from './NotFoundPage';
import BookQueryPage from './BookQueryPage';
import BookStatePage from './BookStatePage';
import WeatherPage from './WeatherPage';
import CommonErrorPage from './CommonErrorPage';
import BookFormPage from './BookFormPage';
import yup from './yup.jp';
import { date, number, string } from 'yup';


const sleep = ms => new Promise(res => setTimeout(res, ms));
const fetchWeather = async ({ params }) => {
    // ローディングメッセージを表示させるために処理を遅延
    await sleep(2000);
    const res = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${params.city}&lang=ja&appid={API_KEY}`);
    // 応答が成功の場合は、そのまま結果データを返す
    if (res.ok) { return res; }
    // レスポンスステータスに応じて、異なるエラー情報をスロー
    switch (res.status) {
        case 404:
            throw json({ message: 'city is invalid!!' }, { status: 404 });
        case 401:
            throw json({ message: 'api key is invalid!!' }, { status: 401 });
        default:
            throw json({ message: 'api server is in trouble...' }, { status: 501 });
    }
}

const bookAction = async ({ request }) => {
    const form = await request.formData();
    // スキーマを定義
    const bookSchema = yup.object({
        title: string().label('書名').required().max(100),
        price: number().label('価格').integer().positive(),
        published: date().label('刊行日').required().max(new Date(2100, 0, 1))
    });
    let info;
    // 検証を実行＆エラー時はメッセージを返す
    try {
        info = await bookSchema.validate({
            title: form.get('title'),
            price: form.get('price') || 0,
            published: new Date(form.get('published') || Date.now()),
        }, {
            abortEarly: false
        });
        console.log(info);
        return redirect('/');
    } catch (e) {
        return e.errors;
    }
};

const routesParam = createBrowserRouter (
    createRoutesFromElements(
        <Route element={<RouterParam />}
            errorElement={<CommonErrorPage />}>
            <Route path="/" element={<TopPage />} />
            <Route path="/book/form" element={<BookFormPage />}
                action={bookAction} />
            <Route path="/book/:isbn?" element={<BookPage />} />
            <Route path="/bookQuery" element={<BookQueryPage />} />
            <Route path="/bookState" element={<BookStatePage />} />
            {/* 可変長パラメーターを定義 */}
            <Route path="/search/*" element={<SearchPage />} />
            <Route path="/weather/:city" element={<WeatherPage />}
                loader={fetchWeather} />
            {/* 任意のページに対応するルート */}
            <Route path="*" element={<NotFoundPage />} />
        </Route>
    )
);

export default routesParam;
