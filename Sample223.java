/* <applet code="Sample223.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample223 extends JApplet {    
    JTextField tf = new JTextField();

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        tf.setToolTipText("テキストフィールドのツールヒント");

        cp.add(tf);
        tf.setText("Hello Java Swing!");
    }
}