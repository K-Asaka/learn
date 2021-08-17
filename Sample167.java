/*  <applet code="Sample167.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

public class Sample167 extends Applet
        implements AdjustmentListener, ActionListener {
    TextField tf1 = new TextField(7);
    TextField tf2 = new TextField(7);
    TextField tf3 = new TextField(7);
    Scrollbar sr = new Scrollbar(Scrollbar.HORIZONTAL, 1, 10, 1, 110);
    Button bt = new Button("値を34に設定します");

    public void init() {
        add(tf1);
        add(tf2);
        add(tf3);
        add(sr);
        sr.addAdjustmentListener(this);

        add(bt);
        bt.addActionListener(this);

        tf1.setText("[最小]: " + sr.getMinimum());
        tf2.setText("[ 値 ]: " + sr.getValue());
        tf3.setText("[最大]: " + sr.getMaximum());
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getAdjustable() == sr) {
            tf2.setText("[ 値 ]: " + sr.getValue());
        }
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bt) {
            // スクロールバーの現在値を設定します
            sr.setValue(34);

            tf2.setText("[ 値 ]: " + sr.getValue());
        }
    }
}
