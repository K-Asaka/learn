import com.nttdocomo.ui.*;

public class Sample410 extends IApplication {
    public void start() {
        // テキストボックスを定義する
        TextBox txtTest;
        Panel pnlDisp = new Panel();

        // テキストボックスを入力可能状態で作成する
        txtTest = new TextBox("", 20, 1, TextBox.DISPLAY_ANY);

        // テキストボックスの色を設定する
        // 前景色を赤にする
        txtTest.setForeground(Graphics.getColorOfName(Graphics.RED));

        // 背景色を青にする
        txtTest.setBackground(Graphics.getColorOfName(Graphics.BLUE));

        // パネルにテキストボックスを追加する
        pnlDisp.add(txtTest);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
