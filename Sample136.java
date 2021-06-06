/*  <applet code="Sample136.class" width="310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class Sample136 extends Applet
        implements MouseListener {

    Point pt1;
    Point pt2;
    boolean bool = false;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        g.drawString("直線を描画する", 10, 60);

        if (bool) {
            g.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        bool = false;
        pt1 = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pt2 = new Point(e.getX(), e.getY());
        bool = true;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
