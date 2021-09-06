/* <applet code="Sample227" width="310" height="200"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample227 extends JApplet {
    public void init() {
        JButton bt = new JButton("確認用ダイアログボックスの表示");

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt);

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 確認用ダイアログボックスを表示する
                int ret = JOptionPane.showConfirmDialog(
                    (Component)null,
                    "はい/いいえ/取消を選択してください",
                    "はい/いいえ/取消を選択",
                    JOptionPane.YES_NO_CANCEL_OPTION              
                );

                // ダイアログボックスで押されたボタンを判定する
                if (ret == JOptionPane.YES_OPTION) {
                    showStatus("はいボタンが押されました");
                } else if (ret == JOptionPane.NO_OPTION) {
                    showStatus("いいえボタンが押されました");
                } else {
                    showStatus("取消ボタンが押されました");
                }
            }
        });
    }
}
