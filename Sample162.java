/*  <applet code="Sample162.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample162 extends Applet
        implements ActionListener {
    TextField tf = new TextField(20);
    List lt = new List(4);

    public void init() {
        add(tf);
        lt.add("リスト0");
        lt.add("リスト1");
        lt.add("リスト2");
        lt.add("リスト3");
        add(lt);

        // 項目名を指定して削除
        lt.remove("リスト0");

        lt.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == lt) {
            String str = ((List)e.getSource()).getSelectedItem();

            // 位置を指定して削除
            lt.remove(lt.getSelectedIndex());

            tf.setText(str + "を削除しました");
        }
    }
}
