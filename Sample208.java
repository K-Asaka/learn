/* <applet code="Sample208.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Sample208 extends JApplet implements ListSelectionListener {
    JList lt;
    JTextField tf = new JTextField(10);

    public void init() {
        String list[] = new String[10];
        for (int i = 0; i < 10; i++) {
            list[i] = "リスト " + (i + 1);
        }
        // リストオブジェクトを作成する
        lt = new JList(list);

        // スクロールペインにリストオブジェクトを追加する
        JScrollPane sp = new JScrollPane(lt);

        // 可視項目を4行に指定する
        lt.setVisibleRowCount(4);
        lt.addListSelectionListener(this);
        
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf);
        cp.add(sp);
    }

    public void valueChanged(ListSelectionEvent e) {
        // 選択項目を取得する
        tf.setText(lt.getSelectedValue() + "を選択");
    }
}