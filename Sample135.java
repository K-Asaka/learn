/*  <applet code="Sample135.class" width="310" height="100"></applet> */
import java.awt.*;
import java.applet.Applet;
public class Sample135 extends Applet {
    Image ig;

    public void init() {
        ig = getImage(getDocumentBase(), "Sample.jpg");
    }

    public void paint(Graphics g) {
        g.drawImage(ig, 35, 10, 30, 40, this);
        g.drawImage(ig, 125, 20, 40, 50, this);
        g.drawImage(ig, 220, 30, 50, 60, this);
    }
}
