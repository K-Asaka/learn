/*  <applet code="Sample163.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample163 extends Applet 
        implements ActionListener {
    List lt = new List(4, true);
    TextField tf = new TextField(30);
    Button bt = new Button("複数選択してクリックする");
    String select[];

    public void init() {
        lt.add("リスト1");
        lt.add("リスト2");
        lt.add("リスト3");
        lt.add("リスト4");
        lt.add("リスト5");
        add(lt);
        add(tf);
        add(bt);
        bt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String str = "";
        String select[];
        if (e.getSource() == bt) {
            // リストで選択されている複数項目を取得
            select = lt.getSelectedItems();

            for (int i = 0; i < select.length; i++) {
                str += " " + select[i];
            }
            tf.setText(str + " を選択");
        }
    }
    
}
