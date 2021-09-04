/* <applet code="Sample206.class" width="310" height="150"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample206 extends JApplet {
    JPanel pl = new JPanel();
    JTextField tf1 = new JTextField("①", 5);
    JTextField tf2 = new JTextField("②", 5);

    public void init() {
        // オーバーレイレイアウトを設定
        pl.setLayout(new OverlayLayout(pl));

        // X, Y軸方向における配置ポイントを0.0～1.0の間で設定する
        tf1.setAlignmentX((float)0.1);
        tf1.setAlignmentY((float)0.1);
        tf2.setAlignmentX((float)0.85);
        tf2.setAlignmentY((float)0.85);

        // テキストフィールドの最大サイズを設定
        tf1.setMaximumSize(new Dimension(120, 80));
        tf2.setMaximumSize(new Dimension(120, 80));

        // テキストフィールドの最小サイズを設定
        tf1.setMinimumSize(new Dimension(100, 60));
        tf2.setMinimumSize(new Dimension(100, 60));
        
        pl.add(tf1);
        pl.add(tf2);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(pl);
    }
}