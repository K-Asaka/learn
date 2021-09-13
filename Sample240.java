/* <applet code="Sample240" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample240 extends JApplet {
    Object[] cell = new Object[5];

    // デフォルトテーブルオブジェクトを作成
    DefaultTableModel tm = new DefaultTableModel();

    // デフォルトテーブルを元にテーブルオブジェクトを作成
    JTable tb = new JTable(tm);
    JScrollPane sp = new JScrollPane(tb);

    public void init() {
        // デフォルトテーブルに列を追加する
        for (int i = 0; i < 4; i++) {
            tm.addColumn("列 " + (i + 1));
        }

        // デフォルトテーブルに行を追加する
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                cell[j] = "セル " + (i + 1) + ":" + (j + 1);
            }
            tm.addRow(cell);
        }
        Container cp = getContentPane();
        cp.add(sp);
    }
}
