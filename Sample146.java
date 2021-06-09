/*  <applet code="Sample146.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample146 extends Applet {
    public void init() {
        Label lb1 = new Label("ラベルの配置指定なし");
        Label lb2 = new Label("ラベルを左側に揃える", Label.LEFT);
        Label lb3 = new Label("ラベルを中央に揃える", Label.CENTER);
        Label lb4 = new Label("ラベルを右側に揃える", Label.RIGHT);

        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
    }
}
