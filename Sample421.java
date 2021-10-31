import com.nttdocomo.ui.*;

public class Sample421 extends IApplication {
    public void start() {
        Panel pnlDisp = new Panel();

        // ティッカーに文字列を渡す
        Ticker tkrTest = new Ticker("iアプリは楽しい!");

        // パネルにティッカーを追加する
        pnlDisp.add(tkrTest);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
