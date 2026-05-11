import { useState } from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { amber, grey } from '@mui/material/colors';
import { CssBaseline, Button, useMediaQuery } from '@mui/material';

export default function MaterialMode() {
    const mode = useMediaQuery('(prefers-color-scheme: dark)') ?
        'dark' : 'light';
    // テーマを定義
    const theme = createTheme({
        palette: {
            mode,
            // mode値に応じてテーマを切り替え
            ...(mode === 'light'
            // ライトモードで利用するパレット
            ? {
                primary: amber,
            }
            // ダークモードで利用するパレット
            : {
                primary: {
                    main: grey[500],
                    contrastText: '#fff'
                },
                background: {
                    default: grey[900],
                    paper: grey[900],
                },
            }),
        },
    });
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Button variant="contained">
                Mode {mode}
            </Button>
        </ThemeProvider>
    );
}
