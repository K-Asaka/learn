/* <applet code="Sample181.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample181 extends JApplet {
    public void init() {
        // テキストフィールドオブジェクトを作成
        JTextField tf = new JTextField();

        // 文字列を設定します
        tf.setText("Hello Java Swing!");

        // 列数を設定します
        tf.setColumns(20);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf);
    }
}
