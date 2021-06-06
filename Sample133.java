/*  <applet code="Sample133.class" width="310" height="100"></applet> */
import java.awt.*;
import java.applet.Applet;
public class Sample133 extends Applet {
    public void paint(Graphics g) {
        g.drawString("標準のフォント", 45, 20);

        Font ft1 = new Font("MS Pゴシック", Font.ITALIC, 15);
        g.setFont(ft1);
        g.drawString("MS P ゴシック:イタリック:15ポイント", 45, 20);

        Font ft2 = new Font("MS 明朝", Font.BOLD, 16);
        g.setFont(ft2);
        g.drawString("MS 明朝:太字:16ポイント", 45, 85);
    }
}
