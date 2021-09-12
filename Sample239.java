/* <applet code="Sample239" width="310" height="130"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample239 extends JApplet implements ActionListener {
    JMenuBar mb = new JMenuBar();
    JMenu mn = new JMenu("メニュー");
    JMenuItem mi1 = new JMenuItem("項目削除");
    JMenuItem mi2 = new JMenuItem("削除項目");

    public void init() {
        mn.add(mi1);
        mn.add(mi2);
        mb.add(mn);
        setJMenuBar(mb);
        mi1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // 項目を削除する
        mn.remove(mi2);
    }
}
