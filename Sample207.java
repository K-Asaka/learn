/* <applet code="Sample207.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample207 extends JApplet {
    // テキストエリアオブジェクトを作成
    JTextArea jt = new JTextArea("abcdefghijklmn", 3, 10);
    
    Button bt = new Button("3～6文字を1234に変更します");

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(jt);
        cp.add(bt);

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // テキストエリアの文字列を変更する
                jt.replaceRange("1234", 2, 6);
            }
        });
    }
}