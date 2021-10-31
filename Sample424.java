import com.nttdocomo.ui.*;
import com.nttdocomo.io.*;

public class Sample424 extends IApplication {
    public void start() {
        // リソースオブジェクトを取得する
        MediaSound mdsTest = MediaManager.getSound("resource:///Sample424.mid");
        try {
            // リソースをロードする
            mdsTest.use();
        } catch (ConnectionException ce) {
        }

        // オーディオ再生オブジェクトを取得する
        AudioPresenter aprTest = AudioPresenter.getAudioPresenter();
        
        // メディアサウンドをセットする
        aprTest.setSound(mdsTest);

        // メディアイメージの再生を開始する
        aprTest.play();
    }
}
