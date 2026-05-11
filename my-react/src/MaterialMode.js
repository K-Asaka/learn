import { useState } from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { amber, grey } from '@mui/material/colors';
import { CssBaseline, Button } from '@mui/material';

export default function MaterialMode() {
    // 現在のモードを管理するState
    const [mode, setMode] = useState('light');
    // State値modeをlight⇔darkで反転
    const toggleMode = () => setMode(prev =>
        prev === 'light' ? 'dark' : 'light'
    );
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
            <Button variant="contained" onClick={toggleMode}>
                Mode {mode}
            </Button>
        </ThemeProvider>
    );
}
