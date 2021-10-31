import com.nttdocomo.ui.*;

public class Sample426 extends IApplication {
    public void start() {
        // 情報ダイアログを作成する
        Dialog dlgTest = new Dialog(Dialog.DIALOG_INFO, "情報");

        // 表示する文字列を設定する
        dlgTest.setText("iアプリからの情報です");

        // ダイアログをスクリーンに表示する
        dlgTest.show();

    }
}
