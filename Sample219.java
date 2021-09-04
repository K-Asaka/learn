/* <applet code="Sample219.class" width="310" height="130"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Sample219 extends JApplet
        implements ActionListener, ChangeListener {

    JSlider sd = new JSlider(SwingConstants.HORIZONTAL, 0, 50 0);
    JTextField tf1 = new JTextField(5);
    JTextField tf2 = new JTextField(5);
    JTextField tf3 = new JTextField(5);
    JButton bt1 = new JButton("最大値を20に設定します");
    JButton bt2 = new JButton("元の値を(50)設定します");
    
    public void init() {
        sd.addChangeListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf1);
        cp.add(tf2);
        cp.add(tf3);
        cp.add(bt1);
        cp.add(bt2);
        cp.add(sd);

        tf1.setText("[最小]: " + sd.getMinimum());
        tf3.setText("[最大]: " + sd.getMaximum());
    }
    public void actionPerformed(ActionEvent e) {
        // スライダーの移動範囲を設定します
        if (e.getSource() == bt1) {
            sd.setExtent(30);
        } else if (e.getSource() == bt2) {
            sd.setExtent(0);
        }
        sd.revalidate();
    }
    public void stateChanged(ChangeEvent e) {
        tf2.setText("[ 値 ]: " + sd.getValue());
    }
}