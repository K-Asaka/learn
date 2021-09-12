/* <applet code="Sample234" width="310" height="130"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample234 extends JApplet implements ItemListener {
    // ラジオボタンオブジェクトを作成
    JRadioButtonMenuItem rb = new JRadioButtonMenuItem("項目2");

    public void init() {
        JMenuBar mb = new JMenuBar();
        JMenu mn = new JMenu("メニュー", true);

        JMenuItem mi1 = new JMenuItem("項目1");
        JMenuItem mi3 = new JMenuItem("項目3");

        mn.add(mi1);
        mn.add(rb);
        mn.add(mi3);
        mb.add(mn);
        setJMenuBar(mb);

        rb.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        // ラジオボタンの選択状態を調べる
        if (e.getStateChange() == ItemEvent.SELECTED) {
            showStatus(rb.getText() + "はチェックされています");
        } else {
            showStatus(rb.getText() + "はチェックされていません");
        }
    }
}
