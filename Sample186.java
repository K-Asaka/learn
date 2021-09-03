/* <applet code="Sample186.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample186 extends JApplet {
    JTextField tf1 = new JTextField("コピー&ペースト", 11);
    JTextField tf2 = new JTextField(11);
    JTextField tf3 = new JTextField("カット&ペースト", 11);
    JTextField tf4 = new JTextField(11);

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf1);
        cp.add(tf2);
        cp.add(tf3);
        cp.add(tf4);

        tf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.selectAll();

                // 選択状態のテキストをコピー
                tf1.copy();

                // 選択状態のテキストを貼り付け
                tf2.paste();
            }
        });

        tf3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf3.selectAll();

                // 選択状態のテキストをカット
                tf3.cut();

                // 選択状態のテキストを貼り付け
                tf4.paste();
            }
        });
    }
}
