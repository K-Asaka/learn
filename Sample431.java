import com.nttdocomo.ui.*;

public class Sample431 extends IApplication {
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
            // 四角形の描画を行う
            g.fillRect(0, 0, 50, 50);
        }
    }
}
