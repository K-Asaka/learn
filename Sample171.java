/*  <applet code="Sample171.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample171 extends Applet implements ActionListener {
    Button bt = new Button("ウィンドウ表示");
    frame fr = new frame();

    public void init() {
        add(bt);
        bt.addActionListener(this);
        fr.setSize(250, 250);
    }

    public void actionPerformed(ActionEvent event) {
        fr.setVisible(true);
    }
}

class frame extends Frame {
    frame() {
        MenuBar mb = new MenuBar();
        Menu mn = new Menu("セパレーター付きメニュー");
        MenuItem mi1 = new MenuItem("項目1");
        MenuItem mi2 = new MenuItem("項目2");
        MenuItem mi3 = new MenuItem("項目3");
        mn.add(mi1);
        mn.add(mi2);
        // セパレーターを追加する
        mn.addSeparator();
        mn.add(mi3);
        mb.add(mn);
        setMenuBar(mb);

        addWindowListener(new WIndowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }
}
