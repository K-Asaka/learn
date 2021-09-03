/* <applet code="Sample192.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample192 extends JApplet {
    JButton bt1 = new JButton("Button1");
    JButton bt2 = new JButton("Button2");
    JButton bt3 = new JButton("Button3");
    JTextField tf = new JTextField(20);

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt1);
        cp.add(bt2);
        cp.add(bt3);
        cp.add(tf);

        // ショートカットキーを設定
        bt2.setMnemonic('B');

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                tf.setText(bt2.getText() + "がクリックされました");
            }
        });
    }
}
