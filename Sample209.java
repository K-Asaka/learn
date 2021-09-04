/* <applet code="Sample209.class" width="310" height="120"></applet> */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Sample209 extends JApplet implements ListSelectionListener {
    JList lt;
    JTextField tf = new JTextField(20);

    public void init() {
        String list[] = new String[10];
        for (int i = 0; i < 10; i++) {
            list[i] = "リスト " + (i + 1);
        }
        lt = new JList(list);
        JScrollPane sp = new JScrollPane(lt);
        lt.setVisibleRowCount(4);
        lt.setSelectionMode(
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lt.addListSelectionListener(this);
        
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf);
        cp.add(sp);
    }

    public void valueChanged(ListSelectionEvent e) {
        String str = "";
        Object select[];

        // リストで選択されている複数項目を取得
        select = lt.getSelectedValues();
        for (int i = 0; i < select.length; i++) {
            str += " " + (select[i]);
        }
        str += " を選択";
        tf.setText(str);
    }
}