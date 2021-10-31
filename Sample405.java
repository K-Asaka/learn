import com.nttdocomo.ui.*;

public class Sample405 extends IApplication {
    public void start() {
        // 高レベルAPIのための表示面(パネル)を定義
        Panel pnlDisp = new Panel();

        // Hello Java!文字列をセットする
        Label lblTest = new Label("Hello Java!");

        // パネルにラベルを追加する
        pnlDisp.add(lblTest);
        
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
