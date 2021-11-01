import com.nttdocomo.ui.*;

public class Sample437 extends IApplication {
    // Canvasクラスを定義する
    private static canvas cvsTest;
    
    public void start() {
        // Canvasオブジェクトを作成する
        canvas cvsTest = new canvas();
        
        // キャンバスを画面上に表示する
        Display.setCurrent(cvsTest);
    }

    // Canvasクラスを継承する
    public class canvas extends Canvas {
        public void paint(Graphics g) {
            int c[] = (g.AQUA, g.BLACK, g.BLUE,
                        g.FUCHSIA, g.GRAY, g.GREEN,
                        g.LIME, g.MAROON, g.NAVY,
                        g.OLIVE, g.PURPLE, g.RED,
                        g.SILVER, g.TEAL, g.WHITE,
                        g.YELLOW);
            // 四角形の描画を行う
            for (int i = 0; i < 20; i++) {
                // ダブルバッファリングを開始する
                g.lock();
                for (int ii = 0; ii < 80; ii++) {
                    g.setColor(g.getColorOfName(c[ii % 16]));
                    g.fillRect(ii, ii, 10, 30);
                }
                // ダブルバッファリングを終了する
                g.unlock(true);
            }
        }
    }
}
