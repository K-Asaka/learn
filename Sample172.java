/*  <applet code="Sample172.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample172 extends Applet implements ActionListener {
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

class frame extends Frame implements ActionListener {
    MenuItem mi1 = new MenuItem("項目1");
    MenuItem mi2 = new MenuItem("項目2");
    MenuItem mi3 = new MenuItem("項目3");
    Label lb = new Label("メニューの状態を表示します");

    frame() {
        add(lb);

        MenuBar mb = new MenuBar();
        Menu mn = new Menu("メニュー (無効項目有り)");
        mn.add(mi1);
        mn.add(mi2);
        mn.add(mi3);
        mb.add(mn);
        setMenuBar(mb);

        mi1.addActionListener(this);
        mi3.addActionListener(this);

        // メニュー項目を無効にする
        mi2.setEnabled(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == mi1) {
            // メニューの項目が有効かどうか調べる
            if (mi2.isEnabled()) {
                lb.setText("項目2は使用可能です");
            } else {
                lb.setText("項目2は使用不可です");
            }
        }
        if (event.getSource() == mi3) {
            // メニュー項目を有効にする
            mi2.setEnabled(true);
        }
    }
}
