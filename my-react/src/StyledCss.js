import css from './StyledCss.css';

export default function StyledCss() {
    return (
        <>
        {/* 外部スタイルシートをインポート */}
        <style jsx>{css}</style>
        <div className="panel"><b>Styled JSX</b>は、JSX式にスタイル定義を埋め込む形式のライブラリです。
        </div>
        </>
    );
}
