/*  <applet code="Sample164.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample164 extends Applet
        implements ActionListener {
    TextField tf = new TextField(20);
    Choice ch = new Choice();
    Button bt = new Button("項目追加");

    public void init() {
        ch.add("項目1");
        ch.add("項目2");
        ch.add("項目3");
        add(ch);
        add(tf);
        add(bt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bt) {
            // 項目を追加する
            ch.addItem("追加項目");

            tf.setText("項目を追加しました");
        }
    }
}
