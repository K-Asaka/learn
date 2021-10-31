import com.nttdocomo.ui.*;

// ComponentListenerインタフェースを実装する
public class Sample411 extends IApplication implements ComponentListener {
    Label lblTest;
    // テキストボックスを定義する
    TextBox txtTest;

    public void start() {
        Panel pnlDisp = new Panel();

        // テキストボックスを入力可能状態で作成する
        txtTest = new TextBox("", 20, 1, TextBox.DISPLAY_ANY);

        // 入力表示用のラベルを作成します
        lblTest = new Label("", Label.LEFT);
        lblTest.setSize(96 15);

        // パネルにテキストボックスを追加する
        pnlDisp.add(txtTest);
        pnlDisp.add(lblTest);

        // コンポーネントリスナーの登録をする
        pnlDisp.setComponentListener(this);

        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }

    // キー入力が行われると以下が実行される
    public void componentAction(Component c, int act, int prm) {
        // テキストボックスのイベントが発生した場合実行
        if (c == txtTest) {
            // 文字列入力確定時のイベントの場合実行
            if (act == ComponentListener.TEXT_CHANGED) {
                // 入力文字列をラベルへ表示
                lblTest.setText(txtTest.getText() + "を入力");
            }
        }
    }
}
