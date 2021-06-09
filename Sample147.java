/*  <applet code="Sample147.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample147 extends Applet {
    public void init() {
        Label lb1 = new Label("下のラベルにセットする文字列");
        Label lb2 = new Label("");
        add(lb1);
        add(lb2);

        // lb1の文字列を取得し、lb2にセットする
        lb2.setText(lb1.getText());
    }
}
