/* <applet code="Sample190.class" width="310" height="100"></applet> */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sample190 extends JApplet {
    // イメージアイコンオブジェクトを作成
    Icon icon = new ImageIcon("sample.jpg");

    // テキストとイメージファイルを表示
    JButton bt = new JButton("画像付きボタン", icon);
    JTextField tf = new JTextField(20);

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(bt);
        cp.add(tf);

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                tf.setText(bt.getText() + "がクリックされました");
            }
        });
    }
}
