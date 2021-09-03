/* <applet code="Sample188.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample188 extends JApplet {
    public void init() {
        // イメージアイコンオブジェクトを作成
        Icon icon = new ImageIcon("sample.jpg");

        // イメージファイルを表示
        JLabel lb = new JLabel(icon, JLabel.CENTER);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(lb);
    }
}
