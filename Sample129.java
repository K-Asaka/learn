/*  <applet code="Sample129.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample129 extends Applet
        implements ActionListener {
    Button bt;
    frame fr;

    public void init() {
        bt = new Button("ウィンドウ表示");
        add(bt);
        bt.addActionListener(this);
        fr = new frame("捜査対象ウインドウ");
        fr.setSize(250, 120);
    }

    public void actionPerformed(ActionEvent event) {
        // ウィンドウを表示
        fr.setVisible(true);
    }
}

class frame extends Frame {
    frame(String title) {
        super(title);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // ウィンドウを非表示
                setVisible(false);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString("閉じるボタンで非表示", 65, 65);
    }
}
