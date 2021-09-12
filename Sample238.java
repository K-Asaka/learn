/* <applet code="Sample238" width="310" height="130"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample238 extends JApplet implements ActionListener {
    JMenuBar mb = new JMenuBar();
    JMenu mn = new JMenu("メニュー", true);
    JMenuItem mi1 = new JMenuItem("項目追加");
    JMenuItem mi2 = new JMenuItem("新規項目");

    public void init() {
        mn.add(mi1);
        mb.add(mn);
        setJMenuBar(mb);
        mi1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // 項目を追加する
        mn.add(mi2);
    }
}
