/* <applet code="Sample237" width="310" height="130"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample237 extends JApplet implements ActionListener {
    JMenuItem mi1 = new JMenuItem("項目1");
    JMenuItem mi2 = new JMenuItem("項目2");

    public void init() {
        JMenuBar mb = new JMenuBar();
        JMenu mn = new JMenu("メニュー", true);
        mn.add(mi1);
        mn.add(mi2);
        mb.add(mn);
        setJMenuBar(mb);
        mi1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // mi1のテキストを取得し、mi2にセットする
        mi2.setText(mi1.getText());
    }
}
