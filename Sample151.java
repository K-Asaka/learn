/*  <applet code="Sample151.class" width="310" height="120"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample151 extends Applet
        implements ItemListener {
    // ラベルの付いたチェックボックスを作成
    Checkbox cb1 = new Checkbox("チェックボックス1");
    Checkbox cb2 = new Checkbox("チェックボックス2");
    Checkbox cb3 = new Checkbox("チェックボックス3");
    TextField tf = new TextField(20);

    public void init() {
        add(cb1);
        add(cb2);
        add(cb3);
        add(tf);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getItemSelectable() == cb1) {
            tf.setText(cb1.getLabel());
        } else if (e.getItemSelectable() == cb2) {
            tf.setText(cb2.getLabel());
        } else if (e.getItemSelectable() == cb3) {
            tf.setText(cb3.getLabel());
        }
    }
}
