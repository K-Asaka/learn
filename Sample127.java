/*  <applet code="Sample127.class" width="310" height="100">
        <param name="htmlpram" value="abcdefg">
    </applet> */
import java.applet.*;
import java.awt.*;
public class Sample127 extends Applet {
    public void paint(Graphics g) {
        g.drawString("HTMLからのパラメータ", 70, 40);
        // パラメータを取得
        g.drawString(getParameter("htmlpram"), 70, 80);
    }    
}
