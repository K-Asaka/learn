import com.nttdocomo.ui.*;

public class Sample433 extends IApplication {
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
            int xArry[] = {10, 10, 50, 50, 20, 40};
            int yArry[] = {10, 50, 50, 10, 50, 50};
            // 点を結ぶ線の描画を行う
            g.drawPolyline(xArry, yArry, 6);
        }
    }
}
