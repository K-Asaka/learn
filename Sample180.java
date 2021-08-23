/* <applet code="Sample180.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample180 extends JApplet {
    public void init() {
        Container contentPane = getContentPane();
        JLabel lb = new JLabel("Hello Java SWING!");
        contentPane.add(lb);
    }
}
