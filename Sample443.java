import com.nttdocomo.ui.*;
import java.util.*;

public class Sample443 extends IApplication {
    // Canvasクラスを定義する
    private static canvas cvsTest;

    public void start() {
        // Canvasオブジェクトを作成する
        cvsTest = new canvas();

        // キャンバスを画面上に表示する
        Display.setCurrent(cvsTest);
    }

    // Canvasクラスを継承する
    public class canvas extends Canvas {
        public void paint(Graphics g) {
            int c[] = {g.AQUA, g.BLACK, g.BLUE, g.FUCHSIA, g.GRAY, g.GREEN,
                        g.LIME, g.MAROON, g.NAVY, g.OLIVE, g.PURPLE, g.RED,
                        g.SILVER, g.TEAL, g.WHITE, g.YELLOW};
            // 乱数オブジェクトを作成する
            Random r = new Random();
            for (int i = 0; i < 1000; i++) {
                g.setColor(g.getColorOfName(c[i % 16]));
                // 四角形の描画(乱数の取得)
                g.fillRect(r.nextInt() % 300,
                            r.nextInt() % 300, 50, 50);
            }
        }
    }
}
