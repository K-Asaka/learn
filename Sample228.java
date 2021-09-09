/* <applet code="Sample228" width="310" height="200"></applet> */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample228 extends JApplet {
    public void init() {
        JButton bt1 = new JButton("情　報ダイアログを表示");
        JButton bt2 = new JButton("警　告ダイアログを表示");
        JButton bt3 = new JButton("エラーダイアログを表示");
        JButton bt4 = new JButton("質　問ダイアログを表示");
        JButton bt5 = new JButton("ダイアログを表示");

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt1);
        cp.add(bt2);
        cp.add(bt3);
        cp.add(bt4);
        cp.add(bt5);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    (Component)null,
                    "情報ダイアログメッセージ",
                    "情報ダイアログ",
                    JOptionPane.INFORMATION_MESSAGE              
                );
            }
        });

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    (Component)null,
                    "警告ダイアログメッセージ",
                    "警告ダイアログ",
                    JOptionPane.WARNING_MESSAGE              
                );
            }
        });

        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    (Component)null,
                    "エラーダイアログメッセージ",
                    "エラーダイアログ",
                    JOptionPane.ERROR_MESSAGE             
                );
            }
        });

        bt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    (Component)null,
                    "質問ダイアログメッセージ",
                    "質問ダイアログ",
                    JOptionPane.QUESTION_MESSAGE              
                );
            }
        });

        bt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    (Component)null,
                    "ダイアログメッセージ",
                    "ダイアログ",
                    JOptionPane.PLAIN_MESSAGE              
                );
            }
        });

    }
}
