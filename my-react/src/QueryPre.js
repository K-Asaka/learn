import { useEffect, useState } from 'react';

// delay秒だけ処理を休止するsleep関数
const sleep = delay => new Promise(resolve => setTimeout(resolve, delay));

// 天気情報を取得するための関数
const fetchWeather = async () => {
    // 処理を遅延させるためのダミーの休止処理
    // await sleep(2000);
    const res = await fetch('https://api.openweathermap.org/data/2.5/weather?lat=35.6895&lon=139.692&lang=ja&appid={API_KEY}');    
    if (res.ok) { return res.json(); }
    // エラー時はその内容をスロー
    throw new Error(res.statusText);
};

export default function QueryPre({ id }) {
    // 天気情報(info)、loading(ロード中か？)、error(エラー情報)を準備
    const [data, setData] = useState(null);
    const [isLoading, setLoading] = useState(true);
    const [error, setError] = useState('');

    // コンポーネント起動時に天気情報を取得
    useEffect(() => {
        setLoading(true);
        fetchWeather()
            // 成功時はinfoを更新
            .then(result => setData(result))
            // 失敗時はerrorを更新
            .catch(err => setError(err.message))
            // 成否に関わらず、isLoadingを更新
            .finally(() => setLoading(false));
    }, []);

    // ロード中であれば、ローディングメッセージを表示
    if (isLoading) {
        return <p>Loading...</p>;
    }

    // 通信エラーが発生した場合には、エラーメッセージを表示
    if (error) {
        return <p>Error: {error}</p>;
    }

    // ロード中でもエラーでもない場合に、結果を表示
    return (
        <figure>
            <img
            src={`https://openweathermap.org/img/wn/${data?.weather?.[0]?.icon}.png`}
            alt={data?.weather?.[0]?.main} />
            <figcaption>{data?.weather?.[0]?.description}</figcaption>
        </figure>
    );
}
