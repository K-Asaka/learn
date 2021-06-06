/* <applet code="Sample126.class"
    width="310" height="100"></applet> */
import java.applet.*;
import java.awt.*;
public class Sample126 extends Applet {
    public void paint(Graphics g) {
        Dimension d = getSize();
        g.drawString("幅　= " + d.width, 130, 40);
        g.drawString("高さ= " + d.height, 130, 60);
    }
}
