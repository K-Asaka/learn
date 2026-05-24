export default function MyTextBox({ label, ref }) {
    return (
        <label>
            {label}：
            <input type="text" size="15" ref={ref} />
        </label>
    );
}
