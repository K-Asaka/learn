import { useErrorBoundary } from 'react-error-boundary';

export default function ErrorEvent() {
    const { showBoundary } = useErrorBoundary();
    const handleClick = () => {
        try {
            throw new Error('Error is occured in MyApp.');
        } catch (e) {
            // ハンドラー内で発生した例外をError Boundaryに引き渡す
            showBoundary(e);
        }
    };
    return (
        <button type="button" onClick={handleClick}>
            エラー発射
        </button>
    );
}
