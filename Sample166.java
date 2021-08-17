/*  <applet code="Sample165.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

public class Sample166 extends Applet
        implements AdjustmentListener {
    TextField tf1 = new TextField(7);
    TextField tf2 = new TextField(7);
    TextField tf3 = new TextField(7);

    // 水平スクロールバーのオブジェクトを作成
    // 初期値1、最大値110、有効値100を指定
    Scrollbar sr = new Scrollbar(Scrollbar.HORIZONTAL, 1, 10, 1, 110);

    public void init() {
        add(tf1);
        add(tf2);
        add(tf3);
        add(sr);
        sr.addAdjustmentListener(this);

        tf1.setText("[最小]: " + sr.getMinimum());
        tf2.setText("[ 値 ]: " + sr.getValue());
        tf3.setText("[最大]: " + sr.getMaximum());
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getAdjustable() == sr) {
            tf2.setText("[ 値 ]: " + sr.getValue());
        }
    }    
}
