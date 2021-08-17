/*  <applet code="Sample170.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Sample170 extends Applet
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

// ActionListenerインタフェースを実装
class frame extends Frame implements ActionListener {
    MenuItem mi1 = new MenuItem("項目1");
    MenuItem mi2 = new MenuItem("項目2");
    MenuItem mi3 = new MenuItem("項目3");
    Label lb = new Label("メニューを選択してください");

    frame() {
        add(lb);

        MenuBar mb = new MenuBar();
        Menu mn = new Menu("メニュー");
        mn.add(mi1);
        mn.add(mi2);
        mn.add(mi3);
        mb.add(mn);
        setMenuBar(mb);

        // ActionListenerにメニューオブジェクトを追加
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    // メニューが選択された時に実行される処理を記述
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == mi1) {
            lb.setText("項目1を選択");
        }
        if (event.getSource() == mi2) {
            lb.setText("項目2を選択");
        }
        if (event.getSource() == mi3) {
            lb.setText("項目3を選択");
        }
    }
}
