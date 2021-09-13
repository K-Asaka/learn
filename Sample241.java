/* <applet code="Sample241" width="310" height="200"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class Sample240 extends JApplet {
    Object[] cell = new Object[5];
    DefaultTableModel tm = new DefaultTableModel();
    JTable tb = new JTable(tm);
    JScrollPane sp = new JScrollPane(tb);
    jpanel pl = new jpanel();

    public void init() {
        for (int i = 0; i < 4; i++) {
            tm.addColumn("列 " + (i + 1));
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                cell[j] = "セル " + (i + 1) + ":" + (j + 1);
            }
            tm.addRow(cell);
        }
        Container cp = getContentPane();
        cp.add(sp, BorderLayout.CENTER);
        cp.add(pl, BorderLayout.SOUTH);
    }

    // 実行時に行を追加する
    class jpanel extends JPanel implements ActionListener {
        JButton bt = new JButton("行を追加");

        public jpanel() {
            add(bt);
            bt.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            // 行数を取得
            int rc = tm.getRowCount();

            // 列数を取得
            int cc = tm.getColumnCount();

            Object[] data = new Object[cc];

            // 行データを作成
            for (int i = 0; i < cc; i++) {
                data[i] = "セル " + (rc + 1) + ":" + (i + 1);
            }

            // 行を追加
            tm.addRow(data);
        }
    }
}
