/* <applet code="Sample196.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample196 extends JApplet implements ItemListener {
    // チェックボックスオブジェクトを作成
    JCheckBox cb1 = new JCheckBox("チェックボックス1");
    JCheckBox cb2 = new JCheckBox("チェックボックス2");

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(cb1);
        cp.add(cb2);

        cb1.addItemListener(this);
        cb2.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        // cb1のラベルを取得し、cb2にセットする
        cb2.setText(cb1.getText());
    }
}
