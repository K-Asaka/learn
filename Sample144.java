/*  <applet code="Sample144.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample144 extends Applet
        implements ActionLisstener {
    
    TextField tf1 = new TextField("エンターキーで下にセット", 20);
    TextField tf2 = new TextField(20);
    
    public void init() {
        add(tf1);
        add(tf2);
        tf1.addActionListener(this);
    }    

    public void actionPerformed(ActionEvent e) {
        // tf1の文字列を取得し、tf2にセットする
        tf2.setText(tf1.getText());
    }
}
