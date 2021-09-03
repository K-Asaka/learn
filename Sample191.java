/* <applet code="Sample191.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample191 extends JApplet {
    JButton bt1 = new JButton("ボタン1");
    JButton bt2 = new JButton("ボタン2");
    JButton bt3 = new JButton("ボタン3");
    JTextField tf = new JTextField(20);

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt1);
        cp.add(bt2);
        cp.add(bt3);
        cp.add(tf);

        // デフォルトボタンを設定
        getRootPane().setDefaultButto(bt2);

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // デフォルトボタンに設定されているかチェック
                if (bt2.isDefaultButton()) {
                    tf.setText("ボタン2をクリックしました");
                }
            }
        });
    }
}
