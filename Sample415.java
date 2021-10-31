import com.nttdocomo.ui.*;

public class Sample415 extends IApplication {
    public void start() {
        // ボタンを定義する
        Button btnTest1, btnTest2;
        Panel pnlDisp = new Panel();

        // ボタンを作成する
        btnTest1 = new Button("ボタン1");
        btnTest2 = new Button("ボタン2");

        // ボタンの色を指定する
        // 前景色を赤に設定する
        btnTest1.setForeground(Graphics.getColorOfName(Graphics.RED));
        // 背景色を青に設定する
        btnTest1.setBackground(Graphics.getColorOfName(Graphics.BLUE));

        // パネルにボタンを追加する
        pnlDisp.add(btnTest1);
        pnlDisp.add(btnTest2);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
