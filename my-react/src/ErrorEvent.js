export default function ErrorEvent() {
    const handleClick = () => {
        throw new Error('Error is occured in MyApp.');
    };
    return (
        <button type="button" onClick={handleClick}>
            エラー発射
        </button>
    );
}
