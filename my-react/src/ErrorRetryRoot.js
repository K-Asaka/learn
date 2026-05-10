import ErrorFallback from './ErrorFallback';
import { ErrorBoundary } from 'react-error-boundary';
import ErrorRetryThrow from './ErrorRetryThrow';

export default function ErrorRetryRoot() {
    // リセット時に実行される処理
    const handleReset = () => console.log('Retry!!');

    return (
        <>
            <h3>Error Boundaryの基本</h3>
            <ErrorBoundary
                onReset={handleReset}
                FallbackComponent={ErrorFallback}>
                <ErrorRetryThrow />
            </ErrorBoundary>
        </>
    );
}
