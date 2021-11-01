import com.nttdocomo.ui.*;

public class Sample438 extends IApplication {
    // Canvasクラスを定義する
    private static canvas cvsTest;

    // Treadクラスを定義する
    private static Thread trdTest;
    
    public void start() {
        // Canvasオブジェクトを作成する
        canvas cvsTest = new canvas();
        
        // キャンバスを画面上に表示する
        Display.setCurrent(cvsTest);

        // Threadオブジェクトを作成する
        trdTest = new Thread(cvsTest);
        trdTest.start();
    }

    // Canvasクラスを継承し、Runnableインタフェースを実装する
    public class canvas extends Canvas implements Runnable {
        private int act;
        private int prm;
        public canvas() {
        }
        public void run() {
            while (true) {
                try {
                    // 100ミリ秒待つ
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                // 再描画する
                repaint();
            }
        }
        public void paint(Graphics g) {
            synchronized (this) {
                g.lock();
                g.setColor(Graphics.getColorOfName(Graphics.WHITE));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Graphics.getColorOfName(Graphics.BLACK));
                // 押されたキーの値を表示する
                g.drawString(prm + "キーを選択", 10, 10);
                g.unlock(true);
            }
        }
        // 低レベルイベントが発生すると実行される
        public void processEvent(int act, int prm) {
            // キーが押されたイベントの場合実行
            if (act == Display.KEY_PRESSED_EVENT) {
                this.prm = prm;
            }
        }
    }
}
