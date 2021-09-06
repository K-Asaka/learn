/* <applet code="Sample221.class" width="310" height="180"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample221 extends JApplet {    
    JButton bt = new JButton("値に5を加算します");
    JProgressBar pb = new JProgressBar();

    public void init() {
        // 進捗バーの方向を縦に設定
        pb.setOrientation(JProgressBar.VERTICAL);
        pb.setValue(50);
        pb.setStringPainted(true);
        pb.setBorder(BorderFactory.createRaisedBevelBorder());

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt);
        cp.add(pb);

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 現在値を取得し、5を加算後、現在地をセット
                pb.setValue(pb.getValue() + 5);
            }
        });
    }
}