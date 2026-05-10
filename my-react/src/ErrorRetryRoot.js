import { ErrorBoundary } from 'react-error-boundary';
import ErrorRetryThrow from './ErrorRetryThrow';

export default function ErrorRetryRoot() {
    // エラー時に実行される処理
    const handleFallback = ({ error, resetErrorBoundary }) => {
        const handleClick = () => resetErrorBoundary();
        return (
            <div>
                <h4>以下のエラーが発生しました。</h4>
                <p>{error.message}</p>
                <button type="button" onClick={handleClick}>
                    Retry
                </button>
            </div>
        );
    };
    // リセット時に実行される処理
    const handleReset = () => console.log('Retry!!');

    return (
        <>
            <h3>Error Boundaryの基本</h3>
            <ErrorBoundary
                onReset={handleReset}
                fallbackRender={handleFallback}>
                <ErrorRetryThrow />
            </ErrorBoundary>
        </>
    );
}
