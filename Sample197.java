/* <applet code="Sample197.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample197 extends JApplet {
    public void init() {
        // イメージアイコンオブジェクトを作成
        Icon icon = new ImageIcon("checkbox.jpg");

        // イメージファイルを表示
        JCheckBox cb1 = new JCheckBox(icon);

        // テキストとイメージファイルを表示
        JCheckBox cb2 = new JCheckBox("チェックボックス", icon);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(cb1);
        cp.add(cb2);
    }
}
