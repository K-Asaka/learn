import java.applet.*;
import java.awt.*;
public class Sample309 extends Applet {
    public void paint(Graphics g) {
        g.drawString(getDocumentBase().toString(), 20, 40);
    }
}
