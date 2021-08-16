/*  <applet code="Sample165.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample165 extends Applet
        implements ItemListener {
    TextField tf = new TextField(20);
    Choice ch = new Choice();

    public void init() {
        ch.add("項目1");
        ch.add("項目2");
        ch.add("項目3");
        add(ch);
        add(tf);
        ch.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getItemSelectable() == ch) {
            // 選択している項目名を取得
            String str = ((Choice)e.getItemSelectable()).getSelectedItem();

            // 項目名を指定して削除
            ch.remove(str);

            tf.setText(str + "を削除しました");
        }
    }
}
