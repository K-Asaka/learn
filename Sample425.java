import com.nttdocomo.ui.*;
import com.nttdocomo.io.*;

// MediaListenerインターフェースを実装する
public class Sample425 extends IApplication implements MediaListener {
    // オーディオ再生オブジェクトを定義する
    AudioPresenter aprTest;

    public void start() {

        // オーディオ再生オブジェクトを取得する
        aprTest = AudioPresenter.getAudioPresenter();

        // リソースオブジェクトを取得する
        MediaSound mdsTest = MediaManager.getSound("resource:///Sample425.mid");
        try {
            // リソースをロードする
            mdsTest.use();
        } catch (ConnectionException ce) {
        }

        // メディアリスナーの登録をする
        aprTest.setMediaListener(this);

        // メディアサウンドをセットする
        aprTest.setSound(mdsTest);
        
        // メディアイメージの再生を開始する
        aprTest.play();
    }

    // サウンド再生に対するイベントが発生すると以下が実行される
    public void mediaAction(MediaPresenter source, int act, int prm) {
        // オーディオ再生オブジェクトのイベントが発生した場合実行
        if (source == aprTest) {
            // 発生イベントで分岐する
            switch (act) {
                case AudioPresenter.AUDIO_COMPLETE:
                    // サウンドの再生終了
                    aprTest.play();
                    break;
                case AudioPresenter.AUDIO_PLAYING:
                    // サウンドの再生開始
                    break;
                case AudioPresenter.AUDIO_STOPPED:
                // サウンドの再生停止
                break;
            }
        }
    }
}
