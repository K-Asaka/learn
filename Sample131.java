/*  <applet code="Sample131.class" width="310" height="100"></applet> */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Sample131 extends Applet
        implements MouseListener, MouseMotionListener {
    
    String msg;

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        g.drawString("マウスを操作して下さい", 90, 60);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            msg = "左ボタンを押しました";
        } else {
            msg = "右ボタンを押しました";
        }
        msg += e.getX() + ", " + e.getY();
        showStatus(msg);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        msg = "マウスをクリックしました";
        showStatus(msg);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        msg = "ボタンを離しました";
        showStatus(msg);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        msg = "マウスが範囲内です";
        showStatus(msg);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        msg = "マウスが範囲外です";
        showStatus(msg);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        msg = "ドラッグ中です";
        showStatus(msg);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        msg = "マウスを動かしています";
        showStatus(msg);
    }
}
