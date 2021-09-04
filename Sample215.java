/* <applet code="Sample215.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Sample215 extends JApplet implements ChangeListener {

    // 横方向、最小値0、最大値50、初期値0で
    // スライダーコントロールオブジェクトを作成
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

        // 最小値を取得
        tf1.setText("[最小]: " + sd.getMinimum());

        // 最大値を取得
        tf3.setText("[最大]: " + sd.getMaximum());
    }

    public void stateChanged(ChangeEvent e) {
        // 現在地を取得
        tf2.setText("[ 値 ]]: " + sd.getValue());
    }
}