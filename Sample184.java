/* <applet code="Sample184.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample184 extends JApplet {
    public void init() {

        JTextField tf = new JTextField("全ての文字を選択", 10);

        // 全ての文字を選択状態にする
        tf.selectAll();

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf);
    }
}
