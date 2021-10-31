import com.nttdocomo.ui.*;

public class Sample408 extends IApplication {
    public void start() {
        // ラベルを定義する
        Label lblTest1, lblTest2, lblTest3;
        Panel pnlDisp = new Panel();

        // 左揃えラベルを作成する
        lblTest1 = new Label("左揃え", Label.LEFT);
        lblTest1.setSize(96, 15);

        // ラベルの色を設定する
        // 前景色を赤に設定する
        lblTest1.setForeground(Graphics.getColorOfName(Graphics.RED));
        // 背景色を青に設定する
        lblTest1.setBackground(Graphics.getColorOfName(Graphics.BLUE));

        // 中央揃えラベルを作成する
        lblTest2 = new Label("中央揃え", Label.CENTER);
        lblTest2.setSize(96, 15);

        // 右揃えラベルを作成する
        lblTest3 = new Label("右揃え", Label.RIGHT);
        lblTest3.setSize(96, 15);

        // パネルにラベルを追加する
        pnlDisp.add(lblTest1);
        pnlDisp.add(lblTest2);
        pnlDisp.add(lblTest3);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
