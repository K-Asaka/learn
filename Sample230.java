/* <applet code="Sample230" width="310" height="200"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample230 extends JApplet implements ActionListener {
    JButton bt = new JButton("文字入力用ダイアログ表示");

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String str = "文字入力してください";

        // 文字入力用ダイアログボックスを表示
        String rt = JOptionPane.showInputDialog(str);

        // 入力された文字をステータスバーに表示
        if (rt == null) {
            showStatus("取消が押されました");
        } else {
            showStatus("文字 : " + rt);
        }
    }
}
