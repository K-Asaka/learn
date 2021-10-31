import com.nttdocomo.ui.*;

public class Sample412 extends IApplication {
    public void start() {
        // テキストボックスを定義する
        TextBox txtTest;
        Panel pnlDisp = new Panel();

        // 複数行ラベル表示テキストボックスを作成する
        txtTest = new TextBox("複数行ラベル表示ができました", 20, 2, TextBox.DISPLAY_ANY);

        // 入力編集不可に設定する
        txtTest.setEditable(false);

        // パネルにテキストボックスを追加する
        pnlDisp.add(txtTest);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
