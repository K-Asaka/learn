/* <applet code="Sample183.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample183 extends JApplet {
    public void init() {

        JTextField tf1 = new JTextField("【左寄せ】", 20);
        JTextField tf2 = new JTextField("【中央揃え】", 20);
        JTextField tf3 = new JTextField("【右寄せ】", 20);

        // テキストフィールドの配置を設定
        tf1.setHorizontalAlignment(JTextField.LEFT);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        tf3.setHorizontalAlignment(JTextField.RIGHT);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf1);
        cp.add(tf2);
        cp.add(tf3);
    }
}
