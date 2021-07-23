/*  <applet code="Sample155.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;

public class Sample155 extends Applet {
    
    public void init() {
        TextField tf1 = new TextField("①", 10);
        TextField tf2 = new TextField("②", 10);
        TextField tf3 = new TextField("③", 10);
        TextField tf4 = new TextField("④", 10);
        TextField tf5 = new TextField("⑤", 10);
        TextField tf6 = new TextField("⑥", 10);
        TextField tf7 = new TextField("⑦", 10);

        // 2行×4列のグリッドレイアウトを設定
        setLayout(new GridLayout(2, 4));
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
    }
}
