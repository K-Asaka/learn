import com.nttdocomo.ui.*;

// SoftKeyListenerインタフェースを実装する
public class Sample429 extends IApplication implements SoftKeyListener {
    public void start() {
        Panel pnlDisp = new Panel();
        
        // ソフトキーリスナーの登録
        pnlDisp.setSoftKeyListener(this);

        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);

        // 左側のソフトキーのラベル文字列を設定する
        pnlDisp.setSoftLabel(Frame.SOFT_KEY_1, "<左]");

        // 左側のソフトキーのラベル文字列を設定する
        pnlDisp.setSoftLabel(Frame.SOFT_KEY_2, "[右>");
    }

    // ソフトキーが押されると以下が実行される
    public void softKeyPressed(int key) {
        // 情報ダイアログを作成する
        Dialog dlgTest = new Dialog(Dialog.DIALOG_INFO, "情報");

        if (key == 0) {
            // 左側のソフトキーが押された時
            dlgTest.setText("<左] が押された");
        } else if (key == 1) {
            // 右側のソフトキーが押された時
            dlgTest.setText("[右> が押された");
        }

        // ダイアログをスクリーンに表示する
        dlgTest.show();
    }

    // ソフトキーが離されると以下が実行される
    public void softKeyReleased(int key) {
    }
}
