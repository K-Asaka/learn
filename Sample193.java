/* <applet code="Sample193.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample193 extends JApplet {
    // トグルボタンオブジェクトを作成
    JToggleButton tg1 = new JToggleButton("トグルボタン1");
    JToggleButton tg2 = new JToggleButton("トグルボタン2");

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tg1);
        cp.add(tg2);

        tg1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // tg1のラベルを取得し、tg2にセットする
                tg2.setText(tg1.getText());
            }
        });
    }
}
