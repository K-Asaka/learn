/* <applet code="Sample232" width="310" height="110"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample232 extends JApplet implements ActionListener {
    JButton bt1 = new JButton("ボタン1");
    JButton bt2 = new JButton("ボタン2");
    JButton bt3 = new JButton("ボタン3");

    public void init() {
        // 垂直方向のツールバーオブジェクトを作成
        JToolBar tb = new JToolBar(JToolBar.VERTICAL);
        tb.add(bt1);
        tb.addSeparator();
        tb.add(bt2);
        tb.addSeparator();
        tb.add(bt3);

        Container cp = getContentPane();
        cp.add(tb, BorderLayout.NORTH);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            showStatus("ボタン1が押されました");
        } else if (e.getSource() == bt2) {
            showStatus("ボタン2が押されました");
        } else if (e.getSource() == bt3) {
            showStatus("ボタン3が押されました");
        }
    }
}
