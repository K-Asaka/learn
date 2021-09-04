/* <applet code="Sample199.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample199 extends JApplet implements ActionListener {
    // タブペインオブジェクトを作成
    JTabbedPane tp = new JTabbedPane();

    JPanel bp = new JPanel();
    JButton bt = new JButton("タブ数を取得");
    
    public void init() {
        // タブペインオブジェクトにタブを追加
        tp.addTab("タブ1", new JLabel("ラベル1"));
        tp.addTab("タブ2", new JLabel("ラベル2"));
        tp.addTab("タブ3", new JLabel("ラベル3"));
        tp.addTab("タブ4", new JLabel("ラベル4"));
        tp.addTab("タブ5", new JLabel("ラベル5"));

        bp.add(bt);
        bt.addActionListener(this);
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tp, BorderLayout.SOUTH);
        cp.add(bp, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        // タブの数を取得
        showStatus(tp.getTabCount() + "個のタブが設定されています");
    }
}
