/* <applet code="Sample195.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample195 extends JApplet {
    public void init() {
        // イメージアイコンオブジェクトを作成
        Icon icon = new ImageIcon("toggle.jpg");

        // イメージファイルを表示
        JToggleButton tg1 = new JToggleButton(icon);

        // テキストとイメージファイルを表示
        JToggleButton tg2 = new JToggleButton("トグルボタン", icon);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tg1);
        cp.add(tg2);
    }
}
