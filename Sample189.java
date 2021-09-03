/* <applet code="Sample189.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample189 extends JApplet {
    public void init() {
        // HTMLを記述しています
        String str = "<html><b>";
        str += "この文字は<br>";
        str += "HTMLを使って表示しています";
        str += "</b></html>";
        JLabel lb = new JLabel(str);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(lb);
    }
}
