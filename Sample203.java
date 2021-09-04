/* <applet code="Sample203.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample203 extends JApplet implements ActionListener {
    JPanel bp = new JPanel();
    JButton bt1 = new JButton("縦に分割");
    JButton bt2 = new JButton("横に分割");
    JTextField tf1 = new JTextField("分割ペイン1");
    JTextField tf2 = new JTextField("分割ペイン2");

    JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tf1, tf2);

    public void init() {
        bp.add(bt1);
        bp.add(bt2);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        Container cp = getContentPane();
        cp.add(sp, BorderLayout.CENTER);
        cp.add(sp, BorderLayout.SOUTH);
        cp.add(bp, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            // 縦に分割する
            sp.setOrientation(JSplitPane.VERTICAL_SPLIT);
        }
        if (e.getSource() == bt2) {
            // 横に分割する
            sp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        }
    }
}
