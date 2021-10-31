import com.nttdocomo.ui.*;

// ComponentListenerインタフェースを実装する
public class Sample416 extends IApplication implements ComponentListener {
    // ボタンを定義する
    Button btnTest1, btnTest2;
    Label lblTest;

    public void start() {
        Panel pnlDisp = new Panel();

        // ボタンを作成する
        btnTest1 = new Button("ボタン1");
        btnTest2 = new Button("ボタン2");

        // 表示用ラベルを作成する
        lblTest = new Label("", Label.LEFT);
        lblTest.setSize(96, 15);

        // パネルにボタンを追加する
        pnlDisp.add(btnTest1);
        pnlDisp.add(btnTest2);

        // パネルにラベルを追加する
        pnlDisp.add(lblTest);

        // コンポーネントリスナーを登録する
        pnlDisp.setComponentListener(this);
        
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }

    // ボタンが押されると以下が実行される
    public void componentAction(Component c, int act, int prm) {
        // ボタンのイベントが発生した場合実行
        // どのボタンが押されたか判断する
        if (c == btnTest1) {
            lblTest.setText("ボタン1が押された");
        } else if (c == btnTest2) {
            lblTest.setText("ボタン2が押された");
        }
    }
}
