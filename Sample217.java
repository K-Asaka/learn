/* <applet code="Sample217.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Sample217 extends JApplet implements ChangeListener {

    JSlider sd = new JSlider(SwingConstants.HORIZONTAL, 0, 50 0);
    JTextField tf1 = new JTextField(5);
    JTextField tf2 = new JTextField(5);
    JTextField tf3 = new JTextField(5);
    
    public void init() {
        sd.addChangeListener(this);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf1);
        cp.add(tf2);
        cp.add(tf3);
        cp.add(sd);
        tf1.setText("[最小]: " + sd.getMinimum());
        tf3.setText("[最大]: " + sd.getMaximum());

        // スライダーコントロールに目盛りを表示する
        sd.setPaintTicks(true);
        sd.setMajorTickSpacing(10);
        sd.setMinorTickSpacing(5);
    }

    public void stateChanged(ChangeEvent e) {
        tf2.setText("[ 値 ]: " + sd.getValue());
    }
}