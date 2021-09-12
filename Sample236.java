/* <applet code="Sample236" width="310" height="130"></applet> */

import java.awt.*;
import javax.swing.*;

public class Sample236 extends JApplet {

    public void init() {
        // イメージアイコンオブジェクトを作成
        Icon icon = new ImageIcon("menu.jpg");
        JMenuBar mb = new JMenuBar();
        JMenu mn = new JMenu("メニュー", true);

        // イメージファイルを表示
        JMenuItem mi1 = new JMenuItem(icon);

        // テキストイメージファイルを表示
        JMenuItem mi2 = new JMenuItem("メニュー項目", icon);
        mn.add(mi1);
        mn.add(mi2);
        mb.add(mn);
        setJMenuBar(mb);
    }
}
