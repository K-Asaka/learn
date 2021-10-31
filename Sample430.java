import com.nttdocomo.ui.*;
import com.nttdocomo.util.*;

public class Sample430 extends IApplication {
    static panel pnlTest;

    public void start() {
        pnlTest = new panel();
        Display.setCurrent(pnlTest);
    }

    // パネルクラスを継承しタイマーリスナーインタフェースを実装する
    class panel extends Panel implements TimerListener {
        // タイマーを定義する
        Timer timTest;
        int cnt = 0;
        Label lblTest;

        panel() {
            lblTest = new Label("");
            add(lblTest);

            // タイマーを作成する
            timTest = new Timer();

            // イベントの発生間隔をミリ秒単位で設定する
            timTest.setTime(1000);

            // イベント発生を継続させる
            timTest.setRepeat(true);

            // タイマーリスナーを登録する
            timTest.setListener(this);

            // タイマーを実行する
            timTest.start();
        }

        // タイマーイベントが発生すると以下が実行される
        public void timerExpired(Timer timTest) {
            // イベント発生ごとに☆を点滅させる
            if (cnt == 0) {
                lblTest.setText("☆☆☆☆☆");
                cnt = 1;
            } else {
                lblTest.setText("");
                cnt = 0;
            }
        }
    }
}
