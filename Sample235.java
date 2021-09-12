/* <applet code="Sample235" width="310" height="130"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample235 extends JApplet implements ActionListener {
    // ボタンオブジェクトを作成
    JButton bt = new JButton("項目2");

    public void init() {
        JMenuBar mb = new JMenuBar();
        JMenu mn = new JMenu("メニュー", true);

        JMenuItem mi1 = new JMenuItem("項目1");
        JMenuItem mi3 = new JMenuItem("項目3");

        mn.add(mi1);
        mn.add(bt);
        mn.add(mi3);
        mb.add(mn);
        setJMenuBar(mb);

        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // ボタンのテキストを取得する
        showStatus(bt.getText() + "選択しました");
    }
}
