/*  <applet code="Sample130.class" width="310" height="150"></applet> */
import java.awt.*;
import java.awt.event.*;

import jdk.internal.org.objectweb.asm.tree.analysis.Frame;

import java.applet.Applet;
public class Sample130 extends Applet
        implements ActionListener {
    Button bt;
    frame fr;

    public void init() {
        bt = new Button("ウィンドウ表示");
        add(bt);
        bt.addActionListener(this);
        fr = new frame("操作対象ウィンドウ");
        fr.setSize(250, 120);
    }

    public void actionPerformed(ActionEvent event) {
        fr.setVisible(true);
    }
}

// MouseListenerインターフェースを実装
class frame extends Frame
        implements MouseListener {

    String msg = "マウスのボタンを押して下さい";

    frame(String title) {
        super(title);

        // イベントソースとイベントリスナを関連付ける
        addMouseListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            msg = "左ボタンを押しました";
        } else {
            msg = "右ボタンを押しました";
        }
        msg += e.getX() + ", " + e.getY();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    public void paint(Graphics g) {
        g.drawString(msg, 50, 65);
    }
}