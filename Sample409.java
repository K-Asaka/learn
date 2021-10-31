import com.nttdocomo.ui.*;

public class Sample409 extends IApplication {
    public void start() {
        // テキストボックスを定義する
        TextBox txtTest;
        Panel pnlDisp = new Panel();

        // テキストボックスを入力可能状態で作成する
        txtTest = new TextBox("", 20, 1, TextBox.DISPLAY_ANY);

        // パネルにテキストボックスを追加する
        pnlDisp.add(txtTest);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
