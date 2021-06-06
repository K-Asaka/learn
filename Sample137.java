/*  <applet code="Sample137.class" width="310" height="100"></applet> */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class Sample137 extends Applet
        implements MouseListener {

    Point pt1;
    Point pt2;
    boolean bool = false;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        g.drawString("四角形を描画する", 10, 60);
        if (bool) {
            int width = pt2.x - pt1.x;
            int height = pt2.y - pt1.y;
            g.drawRect(pt1.x, pt1.y, width, height);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        bool = false;
        pt1 = new Point(e.getX(), e.getY());
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        pt2 = new Point(Math.max(e.getX(), pt1.x), Math.max(e.getY(), pt1.y));
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

    public void actionPerformed(ActionEvent e) {
    }

}
