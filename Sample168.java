/*  <applet code="Sample168.class" width="310" height="110"></applet> */
import java.applet.Applet;
import java.awt.*;

public class Sample168 extends Applet {
    // スクロールペインのオブジェクトを作成
    ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
    tpl = new tpl();

    public void init() {
        // パネルオブジェクトをスクロールペインに追加
        sp.add(pl);
        add(sp);
    }
}

class tpl extends Panel {
    // 推奨サイズを指定する
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }

    public void paint(Graphics g) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        g.drawString(str, 0, 50);
    }
}
