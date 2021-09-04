/* <applet code="Sample198.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample198 extends JApplet implements ItemListener {
    // ラジオボタンオブジェクトを作成
    JRadioButton rb1 = new JRadioButton("ラジオボタン1");
    JRadioButton rb2 = new JRadioButton("ラジオボタン2");

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(rb1);
        cp.add(rb2);

        // ボタングループオブジェクトを作成
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
    }

    public void itemStateChanged(ItemEvent e) {
        // rb1のラベルを取得し、rb2にセットする
        rb2.setText(rb1.getText());
    }
}
