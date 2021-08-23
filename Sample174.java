/*  <applet code="Sample174.class" width="310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Sample174 extends Applet implements ActionListener {
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

        Menu mn = new Menu("メニュー (サブメニュー付き) ");

        MenuItem mi1 = new MenuItem("項目1");
        MenuItem mi2 = new MenuItem("項目2");
        MenuItem mi3 = new MenuItem("項目3");

        mn.add(mi1);
        mn.add(mi2);
        mn.add(mi3);

        // サブメニューを作成
        Menu smn = new Menu("サブメニュー");
        MenuItem smi1 = new MenuItem("サブメニュー項目1");
        MenuItem smi2 = new MenuItem("サブメニュー項目2");
        smn.add(smi1);
        smn.add(smi2);

        // サブメニューをメニューに追加
        mn.add(smn);

        mb.add(mn);
        setMenuBar(mb);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }
}
