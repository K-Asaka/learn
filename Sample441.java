import com.nttdocomo.ui.*;

// ComponentListenerインタフェースを実装する
public class Sample441 extends IApplication implements ComponentListener {
    // ボタンを定義
    Button btnTest1, btnTest2;
    Label lblTest;
    
    public void start() {
        Panel pnlDisp = new Panel();

        // ボタンを作成する
        btnTest1 = new Button("点灯");
        btnTest2 = new Button("消灯");

        // 状態表示用ラベルを作成する
        lblTest = new Label("", Label.LEFT);
        lblTest.setSize(96, 15);

        pnlDisp.add(btnTest1);
        pnlDisp.add(btnTest2);
        pnlDisp.add(lblTest);

        // コンポーネントリスナーを登録する
        pnlDisp.setComponentListener(this);
        Display.setCurrent(pnlDisp);
    }

    // ボタンが押されると以下が実行される
    public void componentAction(Component c, int act, int prm) {
        if (c == btnTest1) {
            // btnTest1ボタンのイベントが発生した場合実行
            // バックライトを点灯する
            PhoneSystem.setAttribute(PhoneSystem.DEV_BACKLIGHT, PhoneSystem.ATTR_BACKLIGHT_ON);
            lblTest.setText("バックライト点灯");
        } else if (c == btnTest2) {
            // btnTest2ボタンのイベントが発生した場合実行
            // バックライトを消灯する
            PhoneSystem.setAttribute(PhoneSystem.DEV_BACKLIGHT, PhoneSystem.ATTR_BACKLIGHT_OFF);
            lblTest.setText("バックライト消灯");
        }
    }
}
