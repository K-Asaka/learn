/* <applet code="Sample205.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Sample205 extends JApplet {
    public void init() {
        JPanel pl1 = new JPanel();
        JPanel pl2 = new JPanel();

        // 横方向にテキストフィールドを並べる
        pl1.setLayout(new BoxLayout(pl1, BoxLayout.X_AXIS));
        pl1.add(new JTextField("①", 5));
        pl1.add(new JTextField("②", 5));
        pl1.add(new JTextField("③", 5));

        // 縦方向にテキストフィールドを並べる
        pl2.setLayout(new BoxLayout(pl2, BoxLayout.Y_AXIS));
        pl2.add(new JTextField("④", 5));
        pl2.add(new JTextField("⑤", 5));
        pl2.add(new JTextField("⑥", 5));

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(pl1);
        cp.add(pl2);
    }
}