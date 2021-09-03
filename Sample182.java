/* <applet code="Sample182.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;

public class Sample182 extends JApplet {
    public void init() {

        JTextField tf = new JTextField("Hello Java Swing!", 11);

        // フォントオブジェクトを作成
        Font ft = new Font("MS Pゴシック", Font.ITALIC, 25);

        // フォントをセットする
        tf.setFont(ft);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(tf);
    }
}
