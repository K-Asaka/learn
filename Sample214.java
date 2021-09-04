/* <applet code="Sample214.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample214 extends JApplet {
    
    public void init() {
        JPanel pl = new JPanel();
        pl.setLayout(new GridLayout(5, 4));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                pl.add(new JTextField("テキスト" + (i + 1) + ":" + (j + 1)));
            }
        }

        JScrollPane sp = new JScrollPane(
            pl,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        );

        // 見出しを設定する
        JLabel lb1 = new JLabel("列見出し");
        JLabel lb2 = new JLabel("行見出し");
        sp.setColumnHeaderView(lb1);
        sp.setRowHeaderView(lb2);

        Container cp = getContentPane();
        cp.add(sp);
    }
}