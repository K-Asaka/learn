/*  <applet code="Sample132.class" width="310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class Sample132 extends Applet
        implements KeyListener {

    String str = "";

    public void init() {
        addKeyListener(this);
        requestFocus();
    }

    public void paint(Graphics g) {
        g.drawString("キーボードで文字を入力してください", 25, 40);
        g.drawString(str, 25, 70);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        str = str + e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
