/*  <applet code="Sample145.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample145 extends Applet
        implements ActionListener {

    TextField tf1 = new TextField(20);
    TextField tf2 = new TextField("入力したパスワードを表示", 20);

    public void init() {
        add(tf1);
        add(tf2);
        tf1.addActionListener(this);

        // パスワード表示文字を設定
        tf1.setEchoChar('#');
    }

    public void actionPerformed(ActionEvent e) {
        tf2.setText(tf1.getText());
    }    
}
