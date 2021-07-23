/*  <applet code="Sample154.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;

public class Sample154 extends Applet {

    public void init() {
        TextField tf1 = new TextField("①", 10);
        TextField tf2 = new TextField("②", 10);
        TextField tf3 = new TextField("③", 10);

        // コンポーネントを中央揃えにして
        // フローレイアウトを設定
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(tf1);
        add(tf2);
        add(tf3);
    }
}
