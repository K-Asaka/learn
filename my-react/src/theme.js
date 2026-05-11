import { createTheme } from "@mui/material";
import { green, orange } from "@mui/material/colors";

const theme = createTheme({
    // アプリで利用するカラーリング設定
    palette: {
        primary: {
            main: orange[500],
        },
        secondary: {
            main: green[500],
        }
    },
    spacing: 10,
});

export default theme;
