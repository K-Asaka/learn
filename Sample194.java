/* <applet code="Sample194.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample194 extends JApplet {
    JTextField tf = new JTextField(20);
    JToggleButton tg1 = new JToggleButton("トグルボタン1");
    JToggleButton tg2 = new JToggleButton("トグルボタン2");

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tg1);
        cp.add(tg2);
        cp.add(tf);

        // ボタングループオブジェクトを作成
        ButtonGroup bg = new ButtonGroup();

        // ボタングループオブジェクトに
        // トグルボタンオブジェクトを追加する
        bg.add(tg1);
        bg.add(tg2);

        tg1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                tf.setText(tg1.getText() + "がクリックされました");
            }
        });

        tg2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                tf.setText(tg2.getText() + "がクリックされました");
            }
        });
    }
}
