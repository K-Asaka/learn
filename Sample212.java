/* <applet code="Sample212.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample212 extends JApplet {

    // スクロールバーオブジェクトを作成
    private JScrollBar sb = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 115);
    JButton bt1 = new JButton("縦に設定する");
    JButton bt2 = new JButton("横に設定する");
    
    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt1);
        cp.add(bt2);
        cp.add(sb);

        sb.addAdjustmentListener(new addAdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                showStatus("スクロールバーの現在地: " + sb.getValue());
            }
        });

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // スクロールバーの方向を横に設定
                sb.setOrientation(JScrollBar.HORIZONTAL);
            }
        });
    }
}