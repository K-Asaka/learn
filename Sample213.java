/* <applet code="Sample213.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample213 extends JApplet {    
    public void init() {
        JPanel pl = new JPanel();
    
        // パネルに5行x4列のグリッドレイアウトを設定
        pl.setLayout(new GridLayout(5, 4));
    
        // パネルにテキストフィールドを追加
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                pl.add(new JTextField("テキスト" + (i + 1) + ":" + (j + 1)));
            }
        }

        // スクロールペインオブジェクトを作成
        JScrollPane sp = new JScrollPane(
            pl,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        );

        Container cp = getContentPane();
        cp.add(sp);
    }
}