/* <applet code="Sample229" width="310" height="200"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample229 extends JApplet implements ActionListener {
    private JButton bt = new JButton("埋め込みダイアログを表示");
    Container cp = getContentPane();

    public void init() {
        cp.add(bt, BorderLayout.NORTH);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // 埋め込みダイアログボックスを表示する
        JOptionPane.showInternalMessageDialog(
            cp,
            "埋め込み情報ダイアログメッセージ",
            "埋め込み情報ダイアログ",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
