import css from 'styled-jsx/css';

export default css`
.panel {
    width: 300px;
    padding: 10px;
    border: 1px solid #000;
    border-radius: 5px;
    background-color: royalblue;
    color: white;
}`;

// グローバルスタイル
export const globalCss = css.global`
h3 {
    background-color: Yellow;
}
`;

// 埋め込み式のスタイル
export const resolveCss = css.resolve`
.panel {
    margin: 50px;
}`;
