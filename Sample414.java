import com.nttdocomo.ui.*;

public class Sample414 extends IApplication {
    public void start() {
        // ボタンを定義する
        Button btnTest1, btnTest2;
        Panel pnlDisp = new Panel();

        // ボタンを作成する
        btnTest1 = new Button("ボタン1");
        btnTest2 = new Button("ボタン2");

        // パネルにボタンを追加する
        pnlDisp.add(btnTest1);
        pnlDisp.add(btnTest2);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
