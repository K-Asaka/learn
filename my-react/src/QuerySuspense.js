import { useQuery } from 'react-query';

// delay秒だけ処理を休止するsleep関数
const sleep = delay => new Promise(resolve => setTimeout(resolve, delay));

// 天気情報を取得するための関数
const fetchWeather = async () => {
    // ダミーの遅延
    await sleep(2000);
    const res = await fetch('https://api.openweathermap.org/data/2.5/weather?lat=35.6895&lon=139.692&lang=ja&appid=102b5a43634798be2dbf443886cb848b');
    if (res.ok) { return res.json(); }
    // エラー時はその内容をスロー
    throw new Error(res.statusText);
};

export default function QuerySuspense() {
    const { data } = useQuery('weather', fetchWeather);

    return (
        <figure>
            <img
            src={`https://openweathermap.org/img/wn/${data?.weather?.[0]?.icon}.png`}
            alt={data?.weather?.[0]?.main} />
            <figcaption>{data?.weather?.[0]?.description}</figcaption>
        </figure>
    );
}
