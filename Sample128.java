/* <applet code="Sample128.class" width="310" height="100"></applet> */
import java.applet.*;
import java.awt.*;
public class Sample128 extends Applet {
    public void paint(Graphics g) {
        String myStr = "ステータスバーに表示される文字です";
        g.drawString(myStr, 50, 60);
        // ステータスバーに表示
        showStatus(myStr);
    }
}
