/*  <applet code="Sample169.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample169 extends Applet 
        implements ActionListener {
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
        // メニューバーオブジェクトを作成
        MenuBar mb = new MenuBar();

        // 指定したラベルを持つメニューオブジェクトを作成
        Menu mn = new Menu("メニュー");

        // 指定したラベルを持つメニューアイテムオブジェクトを作成
        MenuItem mi1 = new MenuItem("項目1");
        MenuItem mi2 = new MenuItem("項目2");
        MenuItem mi3 = new MenuItem("項目3");

        // メニューアイテムオブジェクトをメニューオブジェクトに追加
        mn.add(mi1);
        mn.add(mi2);
        mn.add(mi3);

        // メニューオブジェクトをメニューバーオブジェクトに追加
        setMenuBar(mb);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }
}
