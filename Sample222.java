/* <applet code="Sample222.class" width="310" height="190"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Sample222 extends JApplet {    
    JTextField tf1 = new JTextField(6);
    JTextField tf2 = new JTextField(6);
    JTextField tf3 = new JTextField(6);
    JButton bt = new JButton("値に5を加算します");
    JProgressBar pb = new JProgressBar();

    public void init() {
        pb.setOrientation(JProgressBar.VERTICAL);
        pb.setValue(50);
        pb.setStringPainted(true);
        pb.setBorder(BorderFactory.createRaisedBevelBorder());

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf1);
        cp.add(tf2);
        cp.add(tf3);
        cp.add(bt);
        cp.add(pb);

        // 最大値、最小値を取得して表示する
        tf1.setText("[最小]: " + pb.getMinimum());
        tf3.setText("[最大]: " + pb.getMaximum());

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pb.setValue(pb.getValue() + 5);
            }
        });

        // 進捗バーの値が変わった時のイベントを処理する
        pb.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tf2.setText("[ 値 ]: " + pb.getValue());
            }
        });
    }
}