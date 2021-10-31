import com.nttdocomo.ui.*;
import com.nttdocomo.io.*;

public class Sample423 extends IApplication {
    public void start() {
        Panel pnlDisp = new Panel();

        // リソースオブジェクトを取得する
        MediaImage mdiTest = MediaManager.getImage("resource:///Sample423.gif");
        try {
            // リソースをロードする
            mdiTest.use();
        } catch (ConnectionException ce) {
        }

        // 表示可能なメディアオブジェクトを作成する
        VisualPresenter vprTest = new VisualPresenter();
        
        // メディアイメージをセットする
        vprTest.setImage(mdiTest);

        // パネルにビジュアルプレゼンターを追加する
        pnlDisp.add(vprTest);
       
        // パネルを画面上に表示する
        Display.setCurrent(pnlDisp);

        // メディアイメージの再生を開始する
        vprTest.play();
    }
}
