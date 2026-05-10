/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import { Button } from '@mui/material';

export default function MaterialBasic() {
    // テキストの大文字／小文字変換を無効化
    const font = css`
        text-transform: none;
    `;
    return (
        <>
            <Button variant="text" css={font}>Text</Button>
            <Button variant="contained" css={font}>Contained</Button>
            <Button variant="outlined" css={font}>Outlined</Button>
        </>
    );
}
