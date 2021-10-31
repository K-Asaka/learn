import com.nttdocomo.ui.*;

// KeyListenerインタフェースを実装する
public class Sample428 extends IApplication implements KeyListener {
    public void start() {
        Panel pnlDisp = new Panel();
        
        // キーリスナーの登録
        pnlDisp.setKeyListener(this);

        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }

    // キーが押されると以下が実行される
    public void keyPressed(Panel p, int key) {
        // 情報ダイアログを作成する
        Dialog dlgTest = new Dialog(Dialog.DIALOG_INFO, "情報");

        // 押されたキーの値を表示文字列に設定する
        dlgTest.setText(" " + Integer.toString(key) + "キーが押された");

        // ダイアログをスクリーンに表示する
        dlgTest.show();
    }

    // キーが離されると以下が実行される
    public void keyReleased(Panel p, int key) {
    }
}
