/* <applet code="Sample204.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample204 extends JApplet {
    public void init() {
        JTextField tf1 = new JTextField("分割ペイン1");
        JTextField tf2 = new JTextField("分割ペイン2");
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tf1, tf2);
    
        Container cp = getContentPane();
        cp.add(sp, BorderLayout.CENTER);

        // ディバイダの幅を取得／設定する
        sp.setDividerSize(sp.getDividerSize() + 15);
    }
}
