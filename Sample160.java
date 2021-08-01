/*  <applet code="Sample160.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample160 extends Applet
        implements ActionListener {
    TextArea ta;
    Button bt = new Button("クリックしてください");

    public void init() {
        // 5行×10桁を表示するテキストエリアを作成
        ta = new TextArea(5, 10);
        add(ta);
        add(bt);
        bt.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt) {
            // テキストエリアに文字列を追加
            ta.append("HelloJava!\n");
        }
    }
}
