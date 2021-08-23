/*  <applet code="Sample173.class" width="310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Sample173 extends Applet implements ActionListener {
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

    // チェックマークメニューを作成
    CheckboxMenuItem cm = new CheckboxMenuItem("項目2 (チェック可能)");

    MenuItem mi3 = new MenuItem("項目3");
    Label lb = new Label("チェックマーク状態を表示します");

    frame() {
        add(lb);

        MenuBar mb = new MenuBar();
        Menu mn = new Menu("チェックマークメニュー");
        mn.add(mi1);
        mn.add(cm);
        mn.add(mi3);
        mb.add(mn);
        setMenuBar(mb);

        mi1.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == mi1) {
            // チェックマークの状態を調べる
            if (cm.getState()) {
                lb.setText("項目2はチェックされています");
            } else {
                lb.setText("項目2はチェックされていません");
            }
        }
    }
}
