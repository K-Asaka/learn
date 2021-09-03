/* <applet code="Sample185.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample185 extends JApplet {
    public void init() {

        JTextField tf = new JTextField("一部の文字を選択");

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf);

        // 一部の文字を選択状態にする
        tf.select(2, 5);
    }
}
