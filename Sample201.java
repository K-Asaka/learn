/* <applet code="Sample201.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample201 extends JApplet {
    public void init() {
        JLabel lb1 = new JLabel("分割ペイン1");
        JLabel lb2 = new JLabel("分割ペイン2");

        // 分割ペインオブジェクトを作成
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, lb1, lb2);
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(sp, BorderLayout.CENTER);
    }
}
