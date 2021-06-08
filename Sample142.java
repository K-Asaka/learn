/*  <applet code="Sample142.class" width="310" height="100"></applet> */
import java.applet.*;
import java.awt.*;
public class Sample142 extends Applet {
    public void paint(Graphics g) {
        Color c = new Color(0, 0, 255);

        // オブジェクトを指定して背景色を設定
        setBackground(c);

        // 定数を指定して前景色を設定
        setForeground(Color.yellow);

        g.drawString("前景色は黄色です", 100, 40);
        g.drawString("背景色は青です", 100, 60);
    }
}
