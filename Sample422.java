import com.nttdocomo.ui.*;
import com.nttdocomo.io.*;

public class Sample422 extends IApplication {
    public void start() {
        Panel pnlDisp = new Panel();

        // リソースオブジェクトを取得する
        MediaImage mdiTest = MediaManager.getImage("resource:///Sample422.gif");
        try {
            // リソースをロードする
            mdiTest.use();
        } catch (ConnectionException ce) {
        }

        // イメージオブジェクトを取得する
        Image imgTest = mdiTest.getImage();
        // ラベル画像を設定しイメージラベルを作成する
        ImageLabel ilbTest = new ImageLabel(imgTest);

        // パネルにイメージラベルを追加する
        pnlDisp.add(ilbTest);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);
    }
}
