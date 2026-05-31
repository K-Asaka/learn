import { isRouteErrorResponse, useRouteError } from 'react-router-dom';

export default function CommonErrorPage() {
    // ルート上で発生したエラーを取得
    const error = useRouteError();
    // Response形式のエラーであるか
    if (isRouteErrorResponse(error)) {
        // ステータスコードに応じてエラーページを生成
        switch (error.status) {
            case 404:
                return <p>目的のページが見つかりませんでした。</p>;
            case 401:
                return <p>認証に失敗しています。</p>;
            case 501:
                return <p>サービスが一時的に停止しています。</p>;
            default:
                return <p>不明なエラー：{error.data.message}</p>;
        }
    }
    // 非Response形式(Error型)の場合のエラーメッセージ
    return (
        <div>
            <h3>問題が発生しました。</h3>
            <p>詳細な問題：{error.message}</p>
        </div>
    );
}
