/* <applet code="Sample231" width="310" height="200"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample231 extends JApplet implements ActionListener {
    JButton bt = new JButton("リストボックスダイアログの表示");

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // リストボックスを作成
        String list[] = new String[3];
        for (int i = 0; i < 3; i++) {
            list[i] = "リスト " + (i + 1);
        }

        // リストボックスを持つダイアログボックスを表示
        String rt = (String)JOptionPane.showInputDialog(
            (Component)null,
            "項目を選択してください",
            "リストボックスダイアログ",
            JOptionPane.QUESTION_MESSAGE,
            null,
            list,
            list[0]
        );

        // リストボックスで選択された値をステータスバーに表示
        if (rt == null) {
            showStatus("取消が押されました");
        } else {
            showStatus("項目 : " + rt);
        }
    }
}
