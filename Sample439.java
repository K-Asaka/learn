import com.nttdocomo.ui.*;

public class Sample439 extends IApplication {
    // Canvasクラスを定義する
    private static canvas cvsTest;
    
    public void start() {
        // Canvasオブジェクトを作成する
        canvas cvsTest = new canvas();
        
        // キャンバスを画面上に表示する
        Display.setCurrent(cvsTest);

        // タイマーを開始する
        cvsTest.startTimer();
    }

    public class canvas extends Canvas {
        private int act;
        private int cnt = 0;
        private ShortTimer timer;
        public canvas() {
        }
        public void startTimer() {
            // タイマーの設定をミリ秒単位で指定
            timer = ShortTimer.getShortTimer(this, 1, 1000, true);

            // タイマーを開始する
            timer.start();
        }
        public void paint(Graphics g) {
            synchronized (this) {
                g.lock();
                if (cnt % 2 == 1) {
                    g.setColor(Graphics.getColorOfName(Graphics.BLACK));
                } else {
                    g.setColor(Graphics.getColorOfName(Graphics.WHITE));
                }
                g.fillRect(0, 0, 300, 300);
                g.unlock(true);
            }
        }
        // 低レベルイベントが発生すると実行される
        public void processEvent(int act, int prm) {
            // タイマーイベントの場合実行
            if (act == Display.TIMER_EXPIRED_EVENT) {
                this.cnt++;
                repaint();
            }
        }
    }
}
