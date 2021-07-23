/*  <applet code="Sample153.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample153 extends Applet {
    
    public void init() {
        TextField tf1 = new TextField("①", 10);
        TextField tf2 = new TextField("②", 10);
        TextField tf3 = new TextField("③", 10);

        // レイアウトを自由に設定する
        setLayout(null);
        add(tf1);
        add(tf2);
        add(tf3);

        // コンポーネントを指定した位置に配置する
        tf1.setBounds( 30, 10, 60, 30);
        tf2.setBounds( 90, 40, 60, 30);
        tf3.setBounds(150, 70, 60, 30);
    }
}
