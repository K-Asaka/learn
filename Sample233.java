/* <applet code="Sample233" width="310" height="100"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample233 extends JApplet
        implements ActionListener, ItemListener {
        
    JToolBar tb = new JToolBar();
    JButton bt1 = new JButton("ボタン1");

    // コンボボックスオブジェクトを作成
    JComboBox cb = new JComboBox();

    JButton bt3 = new JButton("ボタン3");

    public void init() {

        cb.addItem("項目1");
        cb.addItem("項目2");
        cb.addItem("項目3");
        cb.addItemListener(this);

        tb.add(bt1);
        tb.addSeparator();

        // コンボボックスオブジェクトをツールバーに追加
        tb.add(cb);

        tb.addSeparatero();
        tb.add(bt3);

        Container cp = getContentPane();
        cp.add(tb, BorderLayout.NORTH);

        bt1.addActionListener(this);
        bt3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            showStatus("ボタン1が押されました");
        } else if (e.getSource() == bt3) {
            showStatus("ボタン3が押されました");
        }
    }

    // コンボボックスで選択された項目を取得
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            showStatus(e.getItem() + " が選択されました");
        }
    }
}
