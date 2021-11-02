import com.nttdocomo.ui.*;

public class Sample442 extends IApplication {
    public void start() {
        Panel pnlDisp = new Panel();
        Label lblTest = new Label("エラーテスト");
        try {
            // エラー検出を行うコードを記述する
            lblTest.setForeground(-255);
        } catch (IllegalArgumentException err) {
            // エラー発生時に実行される
            lblTest.setText("エラー回避");
            lblTest.setForeground(255));
        }
        pnlDisp.add(lblTest);
        Display.setCurrent(pnlDisp);
    }
}
