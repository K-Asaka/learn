import { useRouteError } from 'react-router-dom';

export default function InvalidParamsPage() {
    // ルート上で発生したエラーを取得
    const error = useRouteError();
    return (
        <p style={{ color: 'Red' }}>{error.message}</p>
    );
}
