/* <applet code="Sample202.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample202 extends JApplet {
    public void init() {
        JTextField tf1 = new JTextField("拡張可能ペイン1");
        JTextField tf2 = new JTextField("拡張可能ペイン2");
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tf1, tf2);
        
        Container cp = getContentPane();
        cp.add(sp, BorderLayout.CENTER);

        // ワンタッチ拡張を使用する
        sp.setOneTouchExpandable(true);
    }
}
