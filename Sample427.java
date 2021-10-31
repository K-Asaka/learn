import com.nttdocomo.ui.*;

public class Sample427 extends IApplication {
    public void start() {
        Panel pnlDisp = new Panel();
        Label lblTest = new Label("", Label.LEFT);
        lblTest.setSize(96, 15);
        pnlDisp.add(lblTest);
        Display.setCurrent(pnlDisp);

        // はい・いいえの2つのボタンを持つダイアログを作成
        Dialog dlgTest = new Dialog(Dialog.DIALOG_YESNO, "ダイアログテスト");

        // 表示する文字列を設定する
        dlgTest.setText("はい / いいえを選択してください");

        // ダイアログをスクリーンに表示する
        // 同時に戻り値を取得する
        int Ret = dlgTest.show();

        if (Ret == Dialog.BUTTON_YES) {
            // はいボタンが選択された場合
            lblTest.setText("はいを選択");
        } else {
            // いいえボタンが選択された場合
            lblTest.setText("いいえを選択");
        }

    }
}
