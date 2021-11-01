import com.nttdocomo.ui.*;

public class Sample434 extends IApplication {
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
            int xArry[] = {20, 10, 25, 30, 40, 50};
            int yArry[] = {10, 25, 35, 45, 50, 20};
            // 多角形の描画を行う
            g.drawPolygon(xArry, yArry, 6);
        }
    }
}
