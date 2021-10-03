import java.applet.*;
import java.awt.*;
public class Sample308 extends Applet {
    public void paint(Graphics g) {
        g.drawString(getCodeBase().toString(), 20, 40);
    }
}
