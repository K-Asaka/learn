/* <applet code="Sample200.class" width="310" height="150"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample200 extends JApplet implements ActionListener {
    JTabbedPane tp = new JTabbedPane(SwingConstants.BOTTOM);

    JPanel bp = new JPanel();
    JButton bt1 = new JButton("上");
    JButton bt2 = new JButton("左");
    JButton bt3 = new JButton("右");
    JButton bt4 = new JButton("下");

    public void init() {
        tp.addTab("タブ1", new JLabel("ラベル1"));
        tp.addTab("タブ2", new JLabel("ラベル2"));
        tp.addTab("タブ3", new JLabel("ラベル3"));

        bp.add(bt1);
        bp.add(bt2);
        bp.add(bt3);
        bp.add(bt4);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tp, BorderLayout.SOUTH);
        cp.add(bp, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            // タブの表示位置を上に設定します
            tp.setTabPlacement(JTabbedPane.TOP);
        } else if (e.getSource() == bt2) {
            // タブの表示位置を左に設定します
            tp.setTabPlacement(JTabbedPane.LEFT);
        } else if (e.getSource() == bt3) {
            // タブの表示位置を右に設定します
            tp.setTabPlacement(JTabbedPane.RIGHT);
        } else if (e.getSource() == bt4) {
            // タブの表示位置を下に設定します
            tp.setTabPlacement(JTabbedPane.BOTTOM);
        }
    }
}
