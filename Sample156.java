/*  <applet code="Sample156.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;

public class Sample156 extends Applet {

    public void init() {
        TextField tf1 = new TextField("①", 10);
        TextField tf2 = new TextField("②", 10);
        TextField tf3 = new TextField("③", 10);
        TextField tf4 = new TextField("④", 10);
        TextField tf5 = new TextField("⑤", 10);

        // ボーダーレイアウトを設定
        setLayout(new BorderLayout());
        add("Center", tf1);
        add("West", tf2);
        add("East", tf3);
        add("South", tf4);
        add("North", tf5);
    }
}
